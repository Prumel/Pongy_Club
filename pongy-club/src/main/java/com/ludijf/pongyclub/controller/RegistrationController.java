package com.ludijf.pongyclub.controller;

import com.ludijf.pongyclub.entity.LicenseType;
import com.ludijf.pongyclub.entity.dto.RegisterDTO;
import com.ludijf.pongyclub.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/register")
@CrossOrigin("${front.url}")
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        return registrationService.register(registerDTO);
    }

    @GetMapping("/license-type")
    public List<LicenseType> getLicenseType() {
        return registrationService.getLicenseType();
    }
}