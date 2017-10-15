package vshare.common.dao;

import vshare.common.entity.StorageEntity;

/**
 * Created by Dell on 10/15/2017.
 */
public interface StorageDAO {
    boolean addStorage(StorageEntity storageEntity);

    boolean updateStorage(StorageEntity storageEntity);

    boolean deleteStorage(StorageEntity storageEntity);

    StorageEntity findStorageById(long storageId);

    boolean deleteStorageById(long storageId);
}
