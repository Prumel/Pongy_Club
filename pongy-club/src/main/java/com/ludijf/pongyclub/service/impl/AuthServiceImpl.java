package com.ludijf.pongyclub.service.impl;

import com.ludijf.pongyclub.entity.LicensedMember;
import com.ludijf.pongyclub.entity.Role;
import com.ludijf.pongyclub.entity.dto.AuthResponseDTO;
import com.ludijf.pongyclub.entity.dto.LoginDTO;
import com.ludijf.pongyclub.repository.LicensedMemberDao;
import com.ludijf.pongyclub.security.jwt.JWTGenerator;
import com.ludijf.pongyclub.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private JWTGenerator jwtGenerator;
    private LicensedMemberDao licensedMemberDao;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, JWTGenerator jwtGenerator, LicensedMemberDao licensedMemberDao) {
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
        this.licensedMemberDao = licensedMemberDao;
    }

    @Override
    public ResponseEntity<AuthResponseDTO> login(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()));


        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);


        LicensedMember licensedMember = licensedMemberDao.findByUsername(loginDTO.getUsername()).get();
        List<Role> licensedMemberRoles = licensedMember.getRoles();
        String memberRole = "";
        for (Role role : licensedMemberRoles) {
            if (role.getName().equals("ADMIN")) {
                memberRole = "ADMIN";
            } else {
                memberRole = "USER";
            }}

        return new ResponseEntity<>(new AuthResponseDTO(token, memberRole), HttpStatus.OK);
    }
}