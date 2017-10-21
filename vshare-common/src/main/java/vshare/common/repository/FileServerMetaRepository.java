package vshare.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import vshare.common.entity.FileServerMetaEntity;
import vshare.common.entity.FileServerMetaEntityPK;

@Service("fileServerMetaRepository")
public interface FileServerMetaRepository extends JpaRepository<FileServerMetaEntity, FileServerMetaEntityPK> {
    FileServerMetaEntity findByFileId(Long fileId);

    void deleteByFileId(Long fileId);
}
