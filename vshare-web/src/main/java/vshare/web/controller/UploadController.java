package vshare.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = "upload")
public class UploadController extends BaseController {
    @GetMapping
    String getUploadUI() {
        return "upload";
    }

    @PostMapping
    String processUpload(@RequestParam("file") MultipartFile multipartFile) {

        return "upload_success";
    }
}
