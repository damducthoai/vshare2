package vshare.common.service;

import vshare.common.entity.FileEntity;

import java.util.List;

public interface FileManager {
    List<FileEntity> getOwnFiles(Long folderId);
}