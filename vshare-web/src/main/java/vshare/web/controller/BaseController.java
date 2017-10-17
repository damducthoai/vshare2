package vshare.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import vshare.common.binding.ActionResult;
import vshare.common.binding.RegisterInfo;
import vshare.common.entity.FileEntity;
import vshare.common.entity.FolderEntity;
import vshare.common.service.Biz;
import vshare.common.service.FileManager;
import vshare.common.service.FolderManager;
import vshare.common.service.RegistrationService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin
public class BaseController implements FileManager, FolderManager, RegistrationService {
    @Resource(name = "fileManager")
    FileManager fileManager;

    @Resource(name = "folderManager")
    FolderManager folderManager;

    @Resource(name = "registrationService")
    RegistrationService registrationService;

    @Autowired
    protected Biz biz;

    @Override
    public List<FileEntity> getFiles(Long folderId) {
        return fileManager.getFiles(folderId);
    }

    @Override
    public List<FolderEntity> getFolders(Long folderId) {
        return folderManager.getFolders(folderId);
    }

    protected RegisterInfo getRegisterModel() {
        return new RegisterInfo();
    }

    @Override
    public ActionResult createAccount(RegisterInfo info) {
        return registrationService.createAccount(info);
    }
}
