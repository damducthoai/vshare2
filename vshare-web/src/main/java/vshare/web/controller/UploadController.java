package vshare.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = "upload")
@CrossOrigin("*")
public class UploadController extends BaseController {
    @Value("${upload.dir}")
    private String uploadDir;

    @GetMapping
    String getUploadUI() {
        return "upload";
    }

    @PostMapping
    String processUpload(@RequestParam("file") MultipartFile multipartFile) {

        return "upload_success";
    }
}
