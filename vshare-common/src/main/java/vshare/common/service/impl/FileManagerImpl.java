package vshare.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vshare.common.entity.FileEntity;
import vshare.common.repository.FileRepository;
import vshare.common.service.FileManager;
import vshare.common.service.StorageManager;

import java.util.List;

@Service
public class FileManagerImpl implements FileManager {

    @Autowired
    StorageManager storageManager;

    @Autowired
    FileRepository fileRepository;

    @Override
    public List<FileEntity> getOwnFiles(Long folderId) {
        return fileRepository.findAllByFolderId(folderId);
    }
}
