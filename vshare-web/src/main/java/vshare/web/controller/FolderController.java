package vshare.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vshare.common.binding.NewFolder;
import vshare.common.entity.FolderEntity;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "folders")
public class FolderController extends BaseController {
    @PostMapping
    @ResponseBody
    public ResponseEntity<FolderEntity> createFolder(@Valid @ModelAttribute("newFolder") NewFolder newFolder, BindingResult result) {

        ResponseEntity<FolderEntity> res;

        FolderEntity folderEntity = createFolder(newFolder.getParrentId(), newFolder.getName());

        res = folderEntity == null ? res = new ResponseEntity<FolderEntity>(HttpStatus.BAD_REQUEST)
                : new ResponseEntity<FolderEntity>(folderEntity, HttpStatus.OK);

        return res;
    }
}