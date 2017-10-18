package vshare.common.service.impl;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import vshare.common.binding.NewFileEvent;
import vshare.common.service.StorageService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service("storageService")
public class StorageServiceImpl implements StorageService, ApplicationListener<NewFileEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    FTPClient ftpClient;

    @Override
    public void onApplicationEvent(NewFileEvent event) {

    }

    private boolean upload(String host, String username, String password, String uploadDir, File file) {
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

            ftpClient.storeFile(uploadDir + file.getName(), inputStream);

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
