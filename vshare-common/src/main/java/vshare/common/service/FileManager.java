package vshare.common.service;

import org.springframework.web.multipart.MultipartFile;
import vshare.common.entity.FileEntity;

import java.util.List;

public interface FileManager {
    List<FileEntity> getFiles(Long folderId);

    FileEntity uploadFile(Long folderId, MultipartFile file);
}
