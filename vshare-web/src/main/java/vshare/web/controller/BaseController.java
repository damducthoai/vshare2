package vshare.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;
import vshare.common.binding.ActionResult;
import vshare.common.binding.NewFolder;
import vshare.common.binding.RegisterInfo;
import vshare.common.entity.FileEntity;
import vshare.common.entity.FolderEntity;
import vshare.common.entity.PremiumCardEntity;
import vshare.common.entity.ServerEntity;
import vshare.common.service.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin
public class BaseController implements FileManager, FolderManager, ServerManager, PremiumCardManager, RegistrationService {
    @Resource(name = "fileManager")
    FileManager fileManager;

    @Resource(name = "folderManager")
    FolderManager folderManager;

    @Resource(name = "registrationService")
    RegistrationService registrationService;

    @Resource(name = "serverManager")
    ServerManager serverManager;

    @Resource(name = "premiumCardManager")
    PremiumCardManager premiumCardManager;

    @Override
    public List<FileEntity> getFiles(Long folderId) {
        return fileManager.getFiles(folderId);
    }

    @Override
    public FileEntity uploadFile(Long folderId, MultipartFile file) {
        return fileManager.uploadFile(folderId, file);
    }

    @Override
    public FileEntity getFile(String physicalName) {
        return fileManager.getFile(physicalName);
    }

    @Override
    public List<FolderEntity> getFolders(Long folderId) {
        return folderManager.getFolders(folderId);
    }

    @Override
    public FolderEntity createFolder(Long parrentId, String name) {
        return folderManager.createFolder(parrentId, name);
    }

    protected RegisterInfo getRegisterModel() {
        return new RegisterInfo();
    }

    @Override
    public ActionResult createAccount(RegisterInfo info) {
        return registrationService.createAccount(info);
    }

    protected void prepareHomeModel(Model model, Long curFolderId) {
        model.addAttribute("files", getFiles(curFolderId));
        model.addAttribute("folders", getFolders(curFolderId));
        model.addAttribute("curlFolderId", curFolderId);
        model.addAttribute("newFolder", new NewFolder());
    }

    @Override
    public List<ServerEntity> getServers() {
        return serverManager.getServers();
    }

    @Override
    public ServerEntity createServer(ServerEntity server) {
        return serverManager.createServer(server);
    }

    @Override
    public ServerEntity getServer(String serverIp) {
        return serverManager.getServer(serverIp);
    }

    @Override
    public ServerEntity updateServer(String serverIp, ServerEntity server) {
        return serverManager.updateServer(serverIp, server);
    }

    @Override
    public PremiumCardEntity createPremiumCard(long point) {
        return premiumCardManager.createPremiumCard(point);
    }

    @Override
    public boolean upgradePremium(String code) {
        return premiumCardManager.upgradePremium(code);
    }
}
