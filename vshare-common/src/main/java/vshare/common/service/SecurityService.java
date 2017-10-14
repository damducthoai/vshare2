package vshare.common.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

public interface SecurityService {

    Authentication getLoggedInAuthentication();

    String getLoggedInUserName();

    Collection<SimpleGrantedAuthority> getLoggedInAuthorities();
}
