package vshare.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vshare.common.entity.FileEntity;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    FileEntity findByFilePhysicalName(String physicalName);

    List<FileEntity> findAllByStorageId(long storageId);

    List<FileEntity> findAllByFolderId(Long folderId);
}
