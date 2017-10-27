package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vshare.common.entity.FileEntity;
import vshare.common.service.FileManager;
import vshare.common.service.IpService;

@Controller(value = "fileController")
@RequestMapping(path = "files")
public class FileController extends BaseController {

    @Autowired
    IpService ipService;

    @Autowired
    FileManager fileManager;

    @GetMapping("{physicalName}")
    public String getFiles(@PathVariable String physicalName, Model model) {
        FileEntity file = getFile(physicalName);
        model.addAttribute("file", file);
        return "file";
    }

/*
    @PostMapping("{physicalName}")
    public String download(HttpServletRequest request, @PathVariable String physicalName) {
        String res = null;
        FileEntity file = getFile(physicalName);
        DownloadRole role;
        String ip = "";

        if (file == null) {
            res = "404";
        } else {
            ip = ipService.getAccessIp(request);
            role = fileManager.getDownloadRole();
        }
        return res;
    }
*/

   /* @PostMapping
    public ResponseEntity<FileEntity> uploadFile(@ModelAttribute(value = "uploadInfo") UploadFileInfo fileInfo) {
        // TODO
        return null;
    }*/

    @DeleteMapping("{fileId}")
    public ResponseEntity processDelete(@PathVariable("fileId") Long fileId) {
        boolean success = deleteFile(fileId);
        ResponseEntity res = success ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
        return res;
    }


}
