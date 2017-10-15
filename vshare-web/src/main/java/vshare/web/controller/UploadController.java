package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vshare.common.entity.FileEntity;
import vshare.common.entity.StorageEntity;
import vshare.common.entity.UserEntity;
import vshare.common.repository.FileRepository;
import vshare.common.repository.StorageRepository;
import vshare.common.repository.UserRepository;

@Controller
@RequestMapping(path = "upload")
@CrossOrigin("*")
public class UploadController extends BaseController {
    @Value("${upload.dir}")
    private String uploadDir;
    @Autowired
    UserRepository userRepository;
    @Autowired
    FileRepository fileRepository;

    @Autowired
    StorageRepository storageRepository;

    @GetMapping
    String getUploadUI() {
        return "upload";
    }

    @PostMapping
    @ResponseBody
    FileEntity processUpload(@RequestParam("file") MultipartFile multipartFile, @RequestParam(value = "folderId", required = false) Long folderId) {
        FileEntity fileEntity = biz.httpUpload(multipartFile);
        if (folderId != null) {
            fileEntity.setFolderId(folderId);
        }
        UserEntity userEntity = userRepository.findByUserName(biz.getLoggedInUserName());
        StorageEntity storageEntity = storageRepository.findByUserId(userEntity.getUserId());
        fileEntity.setStorageId(storageEntity.getStorageId());
        fileRepository.saveAndFlush(fileEntity);
        return fileEntity;
    }
}
