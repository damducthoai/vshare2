package vshare.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vshare.common.entity.FileEntity;

@Controller
@RequestMapping(path = "download")
public class DownloadController extends BaseController {
    @PostMapping
    String download(@ModelAttribute("file") FileEntity file) {
        return download(file.getFilePhysicalName());
    }
}
