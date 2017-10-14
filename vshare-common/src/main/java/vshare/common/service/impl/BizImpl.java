package vshare.common.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import vshare.common.service.Biz;
import vshare.common.service.SecurityService;

import java.util.Collection;

public class BizImpl implements Biz {
    private static BizImpl ourInstance = new BizImpl();
    private SecurityService securityService;

    private BizImpl() {
    }

    public static BizImpl getInstance() {
        return ourInstance;
    }

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
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
    public Collection<SimpleGrantedAuthority> getLoggedInAuthorities() {
        return securityService.getLoggedInAuthorities();
    }
}
