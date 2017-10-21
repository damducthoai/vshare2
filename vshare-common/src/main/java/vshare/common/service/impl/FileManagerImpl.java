package vshare.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import vshare.common.binding.DownloadRole;
import vshare.common.binding.NewFileEvent;
import vshare.common.entity.FileEntity;
import vshare.common.entity.FileServerMetaEntity;
import vshare.common.entity.PremiumDataEntity;
import vshare.common.entity.ServerEntity;
import vshare.common.repository.FileRepository;
import vshare.common.repository.FileServerMetaRepository;
import vshare.common.repository.PremiumDataRepository;
import vshare.common.repository.ServerRepository;
import vshare.common.service.FileManager;
import vshare.common.service.SecurityService;
import vshare.common.service.StorageManager;
import vshare.common.service.UniqueStringService;

import javax.annotation.Resource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service(value = "fileManager")
public class FileManagerImpl implements FileManager, ApplicationEventPublisherAware {

    ApplicationEventPublisher publisher;

    @Value("${upload.dir}")
    String uploadDir;

    @Autowired
    FileRepository fileRepository;

    @Resource(name = "uniqueStringService")
    UniqueStringService uniqueStringService;

    @Resource(name = "storageManager")
    StorageManager storageManager;

    @Resource(name = "securityService")
    SecurityService securityService;

    @Resource(name = "premiumDataRepository")
    PremiumDataRepository premiumDataRepository;

    @Resource(name = "fileServerMetaRepository")
    FileServerMetaRepository fileServerMetaRepository;

    @Resource(name = "serverRepository")
    ServerRepository serverRepository;

    @Override
    public List<FileEntity> getFiles(Long folderId) {
        long storageId = storageManager.getStorageId();
        return fileRepository.findAllByStorageIdAndFolderId(storageId, folderId);
    }

    @Override
    @Transactional
    public FileEntity uploadFile(Long folderId, MultipartFile file) {
        FileEntity fileEntity = null;
        String physicalName = uniqueStringService.getUniqueString();
        long size = file.getSize();
        try {
            byte[] data = file.getBytes();

            File serverFile = new File(String.format("%s/%s", uploadDir, physicalName));

            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(serverFile));

            outputStream.write(data);

            outputStream.close();

            fileEntity = new FileEntity();

            fileEntity.setStorageId(storageManager.getStorageId());
            fileEntity.setFolderId(folderId);
            fileEntity.setFolderId(folderId);
            fileEntity.setFileSize(file.getSize());
            fileEntity.setFileOriginalName(file.getOriginalFilename());
            fileEntity.setFilePhysicalName(physicalName);

            fileRepository.saveAndFlush(fileEntity);

            fileEntity = fileRepository.findByFilePhysicalName(physicalName);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileEntity != null) {
                publisher.publishEvent(new NewFileEvent(this, physicalName, size));
            }
            return fileEntity;
        }
    }

    @Override
    public FileEntity getFile(String physicalName) {
        return fileRepository.findByFilePhysicalName(physicalName);
    }

    @Override
    public String download(String physicalName) {
        DownloadRole role = getDownloadRole();
        return null;
    }

    @Override
    public DownloadRole getDownloadRole() {
        String downloadUrl = null;
        DownloadRole role = DownloadRole.NORMAL;
        long userId;
        PremiumDataEntity premiumData = null;
        try {
            userId = securityService.getUserId();
            premiumData = premiumDataRepository.findOne(userId);
            if (premiumData != null && premiumData.getDueTo().toLocalDate().isAfter(LocalDate.now())) {
                role = DownloadRole.VIP;
            }
        } catch (Exception e) {
            role = DownloadRole.GUEST;
        } finally {
            switch (role) {
                case VIP:
                    downloadUrl = "vip URL";
                    break;
                case GUEST:
                    downloadUrl = "guest URL";
                    break;
                case NORMAL:
                    downloadUrl = "normal URL";
                    break;
                default:
                    downloadUrl = "default URL";
                    break;
            }
            return role;
        }
    }

    @Override
    public boolean deleteFile(long fileId) {
        boolean success = false;
        try {
            FileEntity file = fileRepository.findOne(fileId);
            if (file == null) {
                success = true;
            } else {

                Long storageId = storageManager.getStorageId();
                if (file.getStorageId().equals(storageId)) {
                    deleteFileFromVPS(fileId);
                    fileRepository.delete(fileId);
                    success = fileRepository.findOne(fileId) == null ? true : false;
                } else {
                    success = false;
                }
            }

        } catch (Exception e) {
            // TODO

        } finally {
            return success;
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    protected void deleteFileFromVPS(Long fileId) {
        String ip = null;
        FileServerMetaEntity metaEntity = fileServerMetaRepository.findByFileId(fileId);
        if (metaEntity != null) {
            ip = metaEntity.getServerIp();

            FileEntity fileEntity = fileRepository.findOne(fileId);

            fileServerMetaRepository.delete(metaEntity);

            ServerEntity server = serverRepository.findOne(ip);
            server.setServerUseableSize(server.getServerUseableSize() + fileEntity.getFileSize());

            serverRepository.save(server);
        }
    }
}
