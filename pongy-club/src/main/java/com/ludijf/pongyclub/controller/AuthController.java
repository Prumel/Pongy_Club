package com.ludijf.pongyclub.controller;

import com.ludijf.pongyclub.entity.dto.AuthResponseDTO;
import com.ludijf.pongyclub.entity.dto.LoginDTO;
import com.ludijf.pongyclub.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("${front.url}")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        return authService.login(loginDTO);
    }
}