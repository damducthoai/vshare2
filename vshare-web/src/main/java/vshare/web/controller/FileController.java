package vshare.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vshare.common.binding.UploadFileInfo;
import vshare.common.entity.FileEntity;

@Controller(value = "fileController")
@RequestMapping(path = "files")
public class FileController extends BaseController {

    @GetMapping
    @ResponseBody
    public ResponseEntity<FileEntity> getFiles() {
        // TODO
        return null;
    }

    @PostMapping
    public ResponseEntity<FileEntity> uploadFile(@ModelAttribute(value = "uploadInfo") UploadFileInfo fileInfo) {
        // TODO
        return null;
    }


}
