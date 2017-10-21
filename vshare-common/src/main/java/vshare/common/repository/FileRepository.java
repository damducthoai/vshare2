package vshare.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import vshare.common.entity.FileEntity;

import java.util.List;

@Repository(value = "fileRepository")
public interface FileRepository extends JpaRepository<FileEntity, Long> {
    FileEntity findByFilePhysicalName(String physicalName);

    List<FileEntity> findAllByStorageId(long storageId);

    List<FileEntity> findAllByFolderId(Long folderId);

    List<FileEntity> findAllByStorageIdAndFolderId(long storageId, Long folderId);

    @Modifying
    void deleteByStorageIdAndFileId(Long storageId, Long fileId);
}
