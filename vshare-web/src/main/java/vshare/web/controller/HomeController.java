package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vshare.common.entity.FileEntity;
import vshare.common.entity.StorageEntity;
import vshare.common.entity.UserEntity;
import vshare.common.repository.FileRepository;
import vshare.common.repository.StorageRepository;
import vshare.common.repository.UserRepository;

import java.util.Collection;

@Controller
@RequestMapping(path = "home")
public class HomeController extends BaseController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FileRepository fileRepository;
    @Autowired
    StorageRepository storageRepository;

    @GetMapping
    String getHomeUI(Model model) {
        String userName = biz.getLoggedInUserName();
        UserEntity userEntity = userRepository.findByUserName(userName);
        StorageEntity storageEntity = storageRepository.findByUserId(userEntity.getUserId());
        Collection<FileEntity> listFile = fileRepository.findAllByStorageId(storageEntity.getStorageId());
        model.addAttribute("files", listFile);
        return "home";
    }
}
