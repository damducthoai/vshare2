package vshare.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vshare.common.entity.FolderEntity;

import java.util.List;

/**
 * Created by Dell on 10/15/2017.
 */
@Repository
public interface FolderRepository extends JpaRepository<FolderEntity, Long> {
    List<FolderEntity> findAllByStorageId(long storageId);

    List<FolderEntity> findAllByFolderId(Long folderId);

    List<FolderEntity> findAllByFolderParent(Long parentId);

    List<FolderEntity> findAllByStorageIdAndFolderParent(long storageId, Long parentId);

    List<FolderEntity> findAllByFolderParentAndStorageId(Long parentId, long storageId);

    FolderEntity findByStorageIdAndFolderName(long storageId, String folderName);
}
