package vshare.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vshare.common.entity.StorageEntity;

/**
 * Created by Dell on 10/15/2017.
 */
@Repository
public interface StorageRepository extends JpaRepository<StorageEntity,Long> {
    StorageEntity findByUserId(long userId);
}
