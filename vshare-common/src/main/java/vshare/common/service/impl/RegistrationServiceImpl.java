package vshare.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vshare.common.binding.ActionResult;
import vshare.common.binding.RegisterInfo;
import vshare.common.entity.AuthorityEntity;
import vshare.common.entity.StorageEntity;
import vshare.common.entity.UserEntity;
import vshare.common.repository.AuthorityRepository;
import vshare.common.repository.StorageRepository;
import vshare.common.repository.UserRepository;
import vshare.common.service.RegistrationService;

import javax.annotation.Resource;

@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {

    @Value("${default.user.storage.size}")
    Long defaultStorageSize;

    @Resource(name = "userRepository")
    UserRepository userRepository;

    @Autowired
    StorageRepository storageRepository;

    @Resource(name = "authorityRepository")
    AuthorityRepository authorityRepository;

    @Override
    public ActionResult createAccount(RegisterInfo info) {
        String msg = "Registration successfully";
        boolean success = false;
        ActionResult result;

//        UserEntity tmp = userRepository.findByUserName(info.getUserName());
//        if (tmp != null) {
//            msg = String.format("%s already used", info.getUserName());
//        }
        if (!info.getUserPassword().equals(info.getUserConfirmPassword())) {
            msg = "Password and confirm password not math";
        } else {

            UserEntity user = new UserEntity();
            user.setUserEmail(info.getUserEmail());
            user.setUserName(info.getUserName());
            user.setUserPassword(info.getUserPassword());

            userRepository.save(user);
            user = userRepository.findByUserName(info.getUserName());

            AuthorityEntity authorityEntity = new AuthorityEntity();
            authorityEntity.setAuthority("ROLE_USER");
            authorityEntity.setUserId(user.getUserId());
            authorityRepository.save(authorityEntity);

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
