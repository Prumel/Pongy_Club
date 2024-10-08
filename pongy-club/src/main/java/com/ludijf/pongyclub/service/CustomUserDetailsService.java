package com.ludijf.pongyclub.service;

import com.ludijf.pongyclub.entity.LicensedMember;
import com.ludijf.pongyclub.entity.Role;
import com.ludijf.pongyclub.repository.LicensedMemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private LicensedMemberDao licensedMemberDao;

    @Autowired
    public CustomUserDetailsService(LicensedMemberDao licensedMemberDao) {
        this.licensedMemberDao = licensedMemberDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LicensedMember userLM = licensedMemberDao.findByUsername(username).orElseThrow( () -> new UsernameNotFoundException("Username not found"));
        return new User(userLM.getUsername(), userLM.getPassword(), mapRolesToAuthorities((userLM.getRoles())));    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
