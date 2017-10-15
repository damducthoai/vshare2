package vshare.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vshare.common.entity.FolderEntity;
import vshare.common.repository.FolderRepository;
import vshare.common.service.FolderManager;

import java.util.List;

@Service
public class FolderManagerImpl implements FolderManager {
    @Autowired
    FolderRepository folderRepository;

    @Override
    public List<FolderEntity> getAll() {
        return null;
    }

    @Override
    public List<FolderEntity> getOwnFolder(Long parentId) {
        return folderRepository.findAllByFolderParent(parentId);
    }

}
