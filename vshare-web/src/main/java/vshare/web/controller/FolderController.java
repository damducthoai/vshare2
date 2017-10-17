package vshare.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vshare.common.binding.NewFolder;
import vshare.common.entity.FolderEntity;

@Controller
@RequestMapping(path = "folders")
public class FolderController extends BaseController {
    @PostMapping
    @ResponseBody
    public FolderEntity createFolder(@ModelAttribute("newFolder") NewFolder newFolder) {
        FolderEntity folderEntity = createFolder(newFolder.getParrentId(), newFolder.getName());
        return folderEntity;
    }
}