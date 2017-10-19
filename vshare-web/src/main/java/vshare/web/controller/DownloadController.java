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
        // TODO
        String res = null;
        if (getFile(file.getFilePhysicalName()) != null) {
            res = "redirect:https://stackoverflow.com/questions/1960240/jquery-ajax-submit-form";
        }
        return res;
    }
}
