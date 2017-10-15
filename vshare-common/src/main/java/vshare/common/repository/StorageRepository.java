package vshare.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vshare.common.entity.StorageEntity;

/**
 * Created by Dell on 10/15/2017.
 */
public interface StorageRepository extends JpaRepository<StorageEntity,Long> {

}
