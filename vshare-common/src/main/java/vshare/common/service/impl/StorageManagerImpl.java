package vshare.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vshare.common.repository.StorageRepository;
import vshare.common.service.SecurityService;
import vshare.common.service.StorageManager;

@Service
public class StorageManagerImpl implements StorageManager {
    @Autowired
    private SecurityService securityService;

    @Autowired
    private StorageRepository storageRepository;

    @Override
    public long getLoggedInStorageId() {
        long userId = securityService.getLoggedInUserId();
        return storageRepository.findByUserId(userId).getStorageId();
    }
}
