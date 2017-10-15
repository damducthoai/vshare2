package vshare.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vshare.common.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    FileEntity findByFilePhysicalName(String physicalName);
}
