package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vshare.common.entity.FolderEntity;
import vshare.common.repository.FolderRepository;
import vshare.common.service.FolderManager;
import vshare.common.service.StorageManager;

import java.util.List;

@Controller
@RequestMapping(path = "folders")
public class FolderController extends BaseController {

    @Autowired
    FolderManager folderManager;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    StorageManager storageManager;

    @GetMapping
    @ResponseBody
    public List<FolderEntity> getFolderList() {
        return folderManager.getOwnFolder(Long.valueOf(2));
    }

    @PostMapping
    @ResponseBody
    public String createFolder(@RequestParam("parrentId") Long parrentId, @RequestParam("folderName") String folderName) {
        FolderEntity folderEntity = new FolderEntity();
        folderEntity.setFolderParent(parrentId);
        folderEntity.setFolderName(folderName);
        long storageId = storageManager.getLoggedInStorageId();
        folderEntity.setStorageId(storageId);
        folderRepository.save(folderEntity);
        return "xinc";
    }
}
