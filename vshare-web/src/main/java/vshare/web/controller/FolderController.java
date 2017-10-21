package vshare.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @DeleteMapping("{folderId}")
    public ResponseEntity<FolderEntity> processDeleteFolder(@PathVariable("folderId") Long folderId) {
        boolean success = deleteFolder(folderId);
        ResponseEntity<FolderEntity> res = success ? new ResponseEntity<FolderEntity>(HttpStatus.OK) :
                new ResponseEntity<FolderEntity>(HttpStatus.BAD_REQUEST);
        return res;
    }
}