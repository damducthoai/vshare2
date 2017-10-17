package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vshare.common.binding.UploadFileInfo;
import vshare.common.repository.FileRepository;
import vshare.common.repository.FolderRepository;
import vshare.common.repository.StorageRepository;
import vshare.common.repository.UserRepository;
import vshare.common.service.FileManager;
import vshare.common.service.FolderManager;
import vshare.common.service.StorageManager;

@Controller
@RequestMapping(path = "home")
public class HomeController extends BaseController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    StorageRepository storageRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FolderController folderController;

    @Autowired
    StorageManager storageManager;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FileManager fileManager;

    @Autowired
    FolderManager folderManager;

    @GetMapping
    String getHomeUI(Model model) {

        Long curFolderId = null;

        model.addAttribute("files", getFiles(curFolderId));
        model.addAttribute("folders", getFolders(curFolderId));
        model.addAttribute("curlFolderId", curFolderId);
        model.addAttribute("uploadInfo", new UploadFileInfo());

        return "home";
    }

    @GetMapping(value = "/{child}")
    String getChildFolder(Model model, @PathVariable("child") Long curFolderId) {

        model.addAttribute("folders", getFolders(curFolderId));
        model.addAttribute("files", getFiles(curFolderId));
        model.addAttribute("curlFolderId", curFolderId);

        return "home";
    }
}
