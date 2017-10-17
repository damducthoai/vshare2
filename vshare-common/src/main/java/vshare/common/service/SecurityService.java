package vshare.common.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import vshare.common.entity.UserEntity;

import java.util.Collection;

public interface SecurityService {

    long getUserId();

    String getUserName();

    Authentication getLoggedInAuthentication();

    String getLoggedInUserName();

    long getLoggedInUserId();

    UserEntity getLoggedInUser();

    Collection<SimpleGrantedAuthority> getLoggedInAuthorities();
}
