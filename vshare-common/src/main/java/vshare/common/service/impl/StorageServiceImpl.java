package vshare.common.service.impl;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import vshare.common.binding.NewFileEvent;
import vshare.common.entity.FileServerMetaEntity;
import vshare.common.entity.ServerEntity;
import vshare.common.repository.FileRepository;
import vshare.common.repository.FileServerMetaRepository;
import vshare.common.repository.ServerRepository;
import vshare.common.service.StorageService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service("storageService")
public class StorageServiceImpl implements StorageService, ApplicationListener<NewFileEvent> {

    @Resource(name = "serverRepository")
    ServerRepository serverRepository;

    @Resource(name = "fileServerMetaRepository")
    FileServerMetaRepository fileServerMetaRepository;

    @Resource(name = "fileRepository")
    FileRepository fileRepository;

    List<ServerEntity> serverList;

    @Value("${upload.dir}")
    String uploadDir;

    @Resource(name = "servers")
    Map<String, Long> servers;

    @Resource(name = "waitingFiles")
    Map<String, Long> waitingFiles;

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    FTPClient ftpClient = new FTPClient();

    @PostConstruct
    public void postInit() {
        serverList = serverRepository.findAll();
        for (ServerEntity server : serverList) {
            servers.put(server.getServerIp(), server.getServerUseableSize());
        }
    }

    @Override
    public void onApplicationEvent(NewFileEvent event) {
        boolean success = false;
        String serveServer = null;
        for (ServerEntity s : serverList) {
            if (s.getServerUseableSize() > event.getSize()) {
                serveServer = s.getServerIp();
                File file = new File(String.format("%s/%s", uploadDir, event.getName()));
                success = upload(s.getServerIp(), s.getServerUser(), s.getServerPassword(), file);
                break;
            }
        }
        if (!success) {
            waitingFiles.put(event.getName(), event.getSize());
        } else {
            long id = fileRepository.findByFilePhysicalName(event.getName()).getFileId();
            FileServerMetaEntity meta = new FileServerMetaEntity();
            meta.setFileId(id);
            meta.setServerIp(serveServer);
            fileServerMetaRepository.save(meta);
        }
    }

    private boolean upload(String host, String username, String password, File file) {
        boolean status = false;
        int reply;
        try {
            ftpClient.connect(host);
            reply = ftpClient.getReplyCode();
            status = true;

            // check if host available
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                LOGGER.error("FTP not available");
                throw new Exception("FTP not available");
            }
            // login to remote ftp server
            ftpClient.login(username, password);
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();

            FileInputStream inputStream = new FileInputStream(file);

            ftpClient.storeFile(file.getName(), inputStream);

            inputStream.close();

            boolean deleted = file.delete();

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                // logout and close connection
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            return status;
        }
    }
}
