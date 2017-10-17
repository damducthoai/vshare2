package vshare.common.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vshare.common.dao.FileDAO;
import vshare.common.entity.FileEntity;
import vshare.common.entity.UserEntity;
import vshare.common.service.Biz;
import vshare.common.service.SecurityService;
import vshare.common.service.UploadService;

import java.util.Collection;

@Service
public class BizImpl implements Biz {
    private static BizImpl ourInstance = new BizImpl();
    private SecurityService securityService;
    private UploadService uploadService;
    private FileDAO fileDAO;

    private BizImpl() {
    }

    public static BizImpl getInstance() {
        return ourInstance;
    }

    public void setUploadService(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    public void setFileDAO(FileDAO fileDAO) {
        this.fileDAO = fileDAO;
    }

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public long getUserId() {
        return securityService.getUserId();
    }

    @Override
    public String getUserName() {
        return securityService.getUserName();
    }

    @Override
    public Authentication getLoggedInAuthentication() {
        return securityService.getLoggedInAuthentication();
    }

    @Override
    public String getLoggedInUserName() {
        return securityService.getLoggedInUserName();
    }

    @Override
    public long getLoggedInUserId() {
        return securityService.getLoggedInUserId();
    }

    @Override
    public UserEntity getLoggedInUser() {
        return securityService.getLoggedInUser();
    }

    @Override
    public Collection<SimpleGrantedAuthority> getLoggedInAuthorities() {
        return securityService.getLoggedInAuthorities();
    }

    @Override
    public FileEntity httpUpload(MultipartFile multipartFile) {
        return uploadService.httpUpload(multipartFile);
    }
}
