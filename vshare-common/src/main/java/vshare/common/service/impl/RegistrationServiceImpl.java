package vshare.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vshare.common.binding.ActionResult;
import vshare.common.binding.RegisterInfo;
import vshare.common.entity.StorageEntity;
import vshare.common.entity.UserEntity;
import vshare.common.repository.StorageRepository;
import vshare.common.repository.UserRepository;
import vshare.common.service.RegistrationService;

@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {

    @Value("${default.user.storage.size}")
    Long defaultStorageSize;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StorageRepository storageRepository;

    @Override
    public ActionResult createAccount(RegisterInfo info) {
        String msg = "Registration successfully";
        boolean success = false;
        ActionResult result;

        if (userRepository.findByUserName(info.getUserName()) != null) {
            msg = String.format("%s already used", info.getUserName());
        }
        if (!info.getUserPassword().equals(info.getUserConfirmPassword())) {
            msg = "Password and confirm password not math";
        } else {

            UserEntity user = new UserEntity();
            user.setUserEmail(info.getUserEmail());
            user.setUserName(info.getUserName());
            user.setUserPassword(info.getUserPassword());

            userRepository.save(user);
            user = userRepository.findByUserName(info.getUserName());

            StorageEntity storageEntity = new StorageEntity();
            storageEntity.setUserId(user.getUserId());
            storageEntity.setCurrentSize(Long.valueOf(0));
            storageEntity.setMaxSize(defaultStorageSize);

            storageRepository.save(storageEntity);

            success = true;
        }
        result = new ActionResult.Builder().success(success).msg(msg).build();
        return result;
    }
}
