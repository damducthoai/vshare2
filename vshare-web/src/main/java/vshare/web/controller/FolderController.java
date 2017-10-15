package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vshare.common.entity.FolderEntity;
import vshare.common.repository.FolderRepository;
import vshare.common.repository.StorageRepository;
import vshare.common.repository.UserRepository;
import vshare.common.service.StorageManager;

import java.util.List;

@Controller
@RequestMapping(path = "folders")
public class FolderController extends BaseController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    StorageRepository storageRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    StorageManager storageManager;

    @GetMapping
    @ResponseBody
    public List<FolderEntity> getFolderList() {
        long storageId = storageManager.getLoggedInStorageId();
        List<FolderEntity> folders = folderRepository.findAllByStorageId(storageId);
        return folders;
    }
}
