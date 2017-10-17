package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vshare.common.entity.StorageEntity;
import vshare.common.entity.UserEntity;
import vshare.common.repository.AuthorityRepository;
import vshare.common.repository.StorageRepository;
import vshare.common.repository.UserRepository;

@Controller
@RequestMapping(path = "registration")
public class RegisterController extends BaseController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    StorageRepository storageRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @GetMapping
    String getRegisterUI() {
        // TODO
        return "register";
    }

    @PostMapping
    String doRegister(@RequestParam(value = "userEmail", required = true) String userEmail,
                      @RequestParam(value = "userName", required = true) String userName,
                      @RequestParam(value = "userPassword", required = true) String userPassword,
                      @RequestParam(value = "userConfirmPassword", required = true) String userConfirmPassword) {
        if (userName.trim() != "" &&
                userEmail.trim() != "" &&
                userPassword.trim() != "" &&
                userConfirmPassword.equals(userPassword) && userRepository.findByUserName(userName) == null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserEmail(userEmail);
            userEntity.setUserName(userName);
            userEntity.setUserPassword(userPassword);

            userRepository.save(userEntity);
            userEntity = userRepository.findByUserName(userName);

            StorageEntity storageEntity = new StorageEntity();
            storageEntity.setUserId(userEntity.getUserId());
            storageEntity.setCurrentSize(Long.valueOf(0));
            storageEntity.setMaxSize(Long.valueOf(50 * 1024 * 2024));

            storageRepository.save(storageEntity);

            return "register_success";
        }
        return "register";
    }
}
