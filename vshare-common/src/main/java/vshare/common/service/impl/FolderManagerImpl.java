package vshare.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vshare.common.entity.FileEntity;
import vshare.common.entity.FolderEntity;
import vshare.common.repository.FileRepository;
import vshare.common.repository.FolderRepository;
import vshare.common.service.FileManager;
import vshare.common.service.FolderManager;
import vshare.common.service.StorageManager;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "folderManager")
public class FolderManagerImpl implements FolderManager {
    @Autowired
    FolderRepository folderRepository;

    @Autowired
    StorageManager storageManager;

    @Resource(name = "fileManager")
    FileManager fileManager;

    @Resource(name = "fileRepository")
    FileRepository fileRepository;

    @Override
    public List<FolderEntity> getFolders(Long folderId) {
        long storageId = storageManager.getStorageId();
        return folderRepository.findAllByStorageIdAndFolderParent(storageId, folderId);
    }

    @Override
    public FolderEntity createFolder(Long parrentId, String name) {
        long storageId = storageManager.getStorageId();

        if (folderRepository.findByStorageIdAndFolderParentAndFolderName(storageId, parrentId, name) != null)
            return null;

        FolderEntity folderEntity = new FolderEntity();

        folderEntity.setFolderParent(parrentId);
        folderEntity.setFolderName(name);
        folderEntity.setStorageId(storageId);
        folderRepository.save(folderEntity);

        return folderRepository.findByStorageIdAndFolderParentAndFolderName(storageId, parrentId, name);
    }

    @Override
    public boolean deleteFolder(Long folderId) {
        List<FileEntity> fileEntityList = fileRepository.findAllByFolderId(folderId);
        if (fileEntityList != null) {
            for (FileEntity file : fileEntityList) {
                fileManager.deleteFile(file.getFileId());
            }
        }
        boolean success = false;
        FolderEntity folder = folderRepository.findOne(folderId);
        if (folder != null) {
            folderRepository.delete(folderId);
            folder = folderRepository.findOne(folderId);
            if (folder == null) success = true;
        } else {
            success = true;
        }
        return success;
    }
}
