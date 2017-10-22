package vshare.web.controller;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;
import vshare.common.binding.ActionResult;
import vshare.common.binding.DownloadRole;
import vshare.common.binding.NewFolder;
import vshare.common.binding.RegisterInfo;
import vshare.common.entity.*;
import vshare.common.repository.PremiumCardRepository;
import vshare.common.service.*;

import javax.annotation.Resource;
import java.util.Collection;
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

    @Resource(name = "premiumCardRepository")
    PremiumCardRepository premiumCardRepository;

    @Resource(name = "securityService")
    SecurityService securityService;


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
    public String download(String physicalName) {
        return fileManager.download(physicalName);
    }

    @Override
    public DownloadRole getDownloadRole() {
        return fileManager.getDownloadRole();
    }

    @Override
    public boolean deleteFile(long fileId) {
        return fileManager.deleteFile(fileId);
    }

    @Override
    public List<FolderEntity> getFolders(Long folderId) {
        return folderManager.getFolders(folderId);
    }

    @Override
    public FolderEntity createFolder(Long parrentId, String name) {
        return folderManager.createFolder(parrentId, name);
    }

    @Override
    public boolean deleteFolder(Long folderId) {
        return folderManager.deleteFolder(folderId);
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
    public boolean deleteServer(String ip) {
        return serverManager.deleteServer(ip);
    }

    @Override
    public PremiumCardEntity createPremiumCard(long point) {
        return premiumCardManager.createPremiumCard(point);
    }

    @Override
    public boolean upgradePremium(String code) {
        return premiumCardManager.upgradePremium(code);
    }

    @Override
    public boolean upgradePremium(long size) {
        return premiumCardManager.upgradePremium(size);
    }

    @Override
    public List<PremiumCardEntity> getCards() {
        return premiumCardManager.getCards();
    }

    @Override
    public PremiumDataEntity getPremiumData() {
        return premiumCardManager.getPremiumData();
    }

    protected PremiumCardEntity getPremiumCardByCode(String code) {
        return premiumCardRepository.findByCardCode(code);
    }

    protected UserEntity getUser() {
        return securityService.getUser();
    }

    protected Collection<SimpleGrantedAuthority> getAuthorities() {
        return securityService.getLoggedInAuthorities();
    }

    protected void changePassword(String newPass) {
        securityService.changePassword(newPass);
    }
}
