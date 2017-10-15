package vshare.common.dao;

import vshare.common.entity.FolderEntity;

/**
 * Created by Dell on 10/15/2017.
 */
public interface FolderDAO {
    boolean addFolder(FolderEntity folderEntity);

    boolean updateFolder(FolderEntity folderEntity);

    boolean deleteFolder(FolderEntity folderEntity);

    FolderEntity findFolderById(long folderId);

    boolean deleteFolderById(long folderId);
}
