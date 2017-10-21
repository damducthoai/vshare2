package vshare.common.service;

import vshare.common.entity.FolderEntity;

import java.util.List;

public interface FolderManager {
    List<FolderEntity> getFolders(Long folderId);

    FolderEntity createFolder(Long parrentId, String name);

    boolean deleteFolder(Long folderId);
}
