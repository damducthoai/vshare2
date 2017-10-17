package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vshare.common.binding.UploadFileInfo;
import vshare.common.entity.FileEntity;
import vshare.common.service.FileManager;

import java.util.List;

@Controller
@RequestMapping(path = "files")
public class FileController extends BaseController {
    @Autowired
    private FileManager fileManager;

    @GetMapping
    @ResponseBody
    public List<FileEntity> getFiles() {
        return null;
    }

    @PostMapping
    public FileEntity uploadFile(@ModelAttribute(value = "uploadInfo") UploadFileInfo fileInfo) {

        return new FileEntity();
    }


}
