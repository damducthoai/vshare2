package vshare.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import vshare.common.binding.NewFileEvent;
import vshare.common.entity.FileEntity;
import vshare.common.repository.FileRepository;
import vshare.common.service.FileManager;
import vshare.common.service.StorageManager;
import vshare.common.service.UniqueStringService;

import javax.annotation.Resource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
