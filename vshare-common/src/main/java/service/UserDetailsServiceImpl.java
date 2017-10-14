package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import vshare.common.entity.AuthorityEntity;
import vshare.common.entity.UserEntity;
import vshare.common.repository.AuthorityRepository;
import vshare.common.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (AuthorityEntity authorityEntity : authorityRepository.findAllByUserId(user.getUserId())) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authorityEntity.getAuthority()));
        }
        return new User(user.getUserName(), user.getUserPassword(), grantedAuthorities);
    }
}
