package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vshare.common.entity.FolderEntity;
import vshare.common.service.FolderManager;

import java.util.List;

@Controller
@RequestMapping(path = "folders")
public class FolderController extends BaseController {

    @Autowired
    FolderManager folderManager;

    @GetMapping
    @ResponseBody
    public List<FolderEntity> getFolderList() {
        return folderManager.getOwnFolder(Long.valueOf(2));
    }
}
