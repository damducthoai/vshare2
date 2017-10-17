package vshare.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vshare.common.entity.FolderEntity;
import vshare.common.repository.FolderRepository;
import vshare.common.service.FolderManager;
import vshare.common.service.StorageManager;

import java.util.List;

@Service(value = "folderManager")
public class FolderManagerImpl implements FolderManager {
    @Autowired
    FolderRepository folderRepository;

    @Autowired
    StorageManager storageManager;

    @Override
    public List<FolderEntity> getFolders(Long folderId) {
        long storageId = storageManager.getStorageId();
        return folderRepository.findAllByStorageIdAndFolderParent(storageId, folderId);
    }
}
