package vshare.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vshare.common.entity.FileEntity;
import vshare.common.repository.FileRepository;
import vshare.common.service.FileManager;
import vshare.common.service.StorageManager;
import vshare.common.service.UniqueStringService;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "fileManager")
public class FileManagerImpl implements FileManager {

    @Autowired
    StorageManager storageManager;

    @Autowired
    FileRepository fileRepository;

    @Resource(name = "uniqueStringService")
    UniqueStringService uniqueStringService;

    @Override
    public List<FileEntity> getFiles(Long folderId) {
        long storageId = storageManager.getStorageId();
        return fileRepository.findAllByStorageIdAndFolderId(storageId, folderId);
    }

    @Override
    public FileEntity uploadFile(Long folderId, MultipartFile file) {
        FileEntity fileEntity = new FileEntity();
        String physicalName = uniqueStringService.getUniqueString();

        fileEntity.setStorageId(storageManager.getStorageId());
        fileEntity.setFolderId(folderId);
        fileEntity.setFolderId(folderId);
        fileEntity.setFileSize(file.getSize());
        fileEntity.setFileOriginalName(file.getOriginalFilename());
        fileEntity.setFilePhysicalName(physicalName);

        fileRepository.saveAndFlush(fileEntity);

        return fileRepository.findByFilePhysicalName(physicalName);
    }
}
