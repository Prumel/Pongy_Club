package com.ludijf.pongyclub.service;

import com.ludijf.pongyclub.entity.LicenseType;
import com.ludijf.pongyclub.entity.dto.RegisterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RegistrationService {

    ResponseEntity <String> register(@RequestBody RegisterDTO registerDTO);

    List<LicenseType> getLicenseType();
}
