package vshare.common.dao.impl;

import vshare.common.dao.FolderDAO;
import vshare.common.entity.FolderEntity;
import vshare.common.repository.FolderRepository;

/**
 * Created by Dell on 10/15/2017.
 */
public class FolderDAOImpl implements FolderDAO {
    FolderRepository folderRepository;
    @Override
    public boolean addFolder(FolderEntity folderEntity) {
        folderRepository.save(folderEntity);
        return true;
    }

    @Override
    public boolean updateFolder(FolderEntity folderEntity) {
        folderRepository.save(folderEntity);
        return true;
    }

    @Override
    public boolean deleteFolder(FolderEntity folderEntity) {
        folderRepository.delete(folderEntity);
        return true;
    }

    @Override
    public FolderEntity findFolderById(long folderId) {
        return folderRepository.findOne(folderId);
    }

    @Override
    public boolean deleteFolderById(long folderId) {
        folderRepository.delete(folderId);
        return true;

    }

    public void setFolderRepository(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }
}
