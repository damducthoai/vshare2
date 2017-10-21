package vshare.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vshare.common.binding.UploadFileInfo;
import vshare.common.entity.FileEntity;

@Controller(value = "fileController")
@RequestMapping(path = "files")
public class FileController extends BaseController {

    @GetMapping("{physicalName}")
    public String getFiles(@PathVariable String physicalName, Model model) {
        FileEntity file = getFile(physicalName);
        model.addAttribute("file", file);
        return "file";
    }

    @PostMapping
    public ResponseEntity<FileEntity> uploadFile(@ModelAttribute(value = "uploadInfo") UploadFileInfo fileInfo) {
        // TODO
        return null;
    }

    @DeleteMapping("{fileId}")
    public ResponseEntity processDelete(@PathVariable("fileId") Long fileId) {
        boolean success = deleteFile(fileId);
        ResponseEntity res = success ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
        return res;
    }


}
