package vshare.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vshare.common.binding.UploadFileInfo;

@Controller
@RequestMapping(path = "home")
public class HomeController extends BaseController {

    @GetMapping
    String getHomeUI(Model model) {

        Long curFolderId = null;

        model.addAttribute("files", getFiles(curFolderId));
        model.addAttribute("folders", getFolders(curFolderId));
        model.addAttribute("curlFolderId", curFolderId);
        model.addAttribute("uploadInfo", new UploadFileInfo());

        return "home";
    }

    @GetMapping(value = "/{folderId}")
    String getChildFolder(Model model, @PathVariable("folderId") Long curFolderId) {

        model.addAttribute("folders", getFolders(curFolderId));
        model.addAttribute("files", getFiles(curFolderId));
        model.addAttribute("curlFolderId", curFolderId);

        return "home";
    }
}
