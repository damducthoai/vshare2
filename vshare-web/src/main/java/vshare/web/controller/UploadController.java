package vshare.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vshare.common.binding.FileUploadInfo;
import vshare.common.entity.FileEntity;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "upload")
public class UploadController extends BaseController {

    @GetMapping
    String getUploadUI(Model model) {
        model.addAttribute("file", new FileUploadInfo());
        return "upload";
    }

    @PostMapping
    @ResponseBody
    ResponseEntity<FileEntity> process(@Valid @ModelAttribute("file") FileUploadInfo info, BindingResult result) {

        ResponseEntity<FileEntity> res = null;

        FileEntity file = null;

        if (result.hasErrors()) {
            res = new ResponseEntity<FileEntity>(HttpStatus.BAD_REQUEST);
        } else {
            file = uploadFile(info.getParrentId(), info.getFile());
            res = new ResponseEntity<FileEntity>(file, HttpStatus.OK);
        }
        return res;
    }
}
