package vshare.common.dao.impl;

import vshare.common.dao.StorageDAO;
import vshare.common.entity.StorageEntity;
import vshare.common.repository.StorageRepository;

/**
 * Created by Dell on 10/15/2017.
 */
public class StorageDAOImpl implements StorageDAO{
    StorageRepository storageRepository;
    @Override
    public boolean addStorage(StorageEntity storageEntity) {
        storageRepository.save(storageEntity);
        return true;
    }

    @Override
    public boolean updateStorage(StorageEntity storageEntity) {
        storageRepository.save(storageEntity);
        return true;
    }

    @Override
    public boolean deleteStorage(StorageEntity storageEntity) {
        storageRepository.delete(storageEntity);
        return true;
    }

    @Override
    public StorageEntity findStorageById(long storageId) {
        return storageRepository.findOne(storageId);
    }

    @Override
    public boolean deleteStorageById(long storageId) {
        storageRepository.delete(storageId);
        return true;
    }
    public void setStorageRepository(StorageRepository storageRepository){this.storageRepository=storageRepository;}
}
