package com.ludijf.pongyclub.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ludijf.pongyclub.entity.LicensedMember;
import com.ludijf.pongyclub.entity.Role;
import com.ludijf.pongyclub.entity.dto.AuthResponseDTO;
import com.ludijf.pongyclub.entity.dto.LoginDTO;
import com.ludijf.pongyclub.repository.LicensedMemberDao;
import com.ludijf.pongyclub.security.jwt.JWTGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

class AuthServiceImplTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JWTGenerator jwtGenerator;

    @Mock
    private LicensedMemberDao licensedMemberDao;

    @InjectMocks
    private AuthServiceImpl authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loginMock() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername("user");

        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(jwtGenerator.generateToken(authentication)).thenReturn("token");

        LicensedMember licensedMember = new LicensedMember();

        Role role = new Role();
        role.setName("USER");

        licensedMember.setRoles(List.of(role));
        when(licensedMemberDao.findByUsername("user")).thenReturn(Optional.of(licensedMember));

        ResponseEntity<AuthResponseDTO> response = authService.login(loginDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("token", response.getBody().getAccessToken());
        assertEquals("USER", response.getBody().getRole());
    }

    @Test
    void loginAdminMock() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername("admin");

        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(jwtGenerator.generateToken(authentication)).thenReturn("token");

        Role role = new Role();
        role.setName("ADMIN");

        LicensedMember licensedMember = new LicensedMember();
        licensedMember.setRoles(List.of(role));
        when(licensedMemberDao.findByUsername("admin")).thenReturn(Optional.of(licensedMember));

        ResponseEntity<AuthResponseDTO> response = authService.login(loginDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("token", response.getBody().getAccessToken());
        assertEquals("ADMIN", response.getBody().getRole());
    }
}