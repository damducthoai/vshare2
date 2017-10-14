package vshare.common.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import vshare.common.service.SecurityService;

import java.util.Collection;

@Service
public class SecurityServiceImpl implements SecurityService {
    @Override
    public String getLoggedInUserName() {
        Authentication authentication = getLoggedInAuthentication();
        String currentUserName = authentication.getName();
        return currentUserName;
    }

    @Override
    public Collection<SimpleGrantedAuthority> getLoggedInAuthorities() {
        return (Collection<SimpleGrantedAuthority>) getLoggedInAuthentication().getAuthorities();
    }

    @Override
    public Authentication getLoggedInAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
