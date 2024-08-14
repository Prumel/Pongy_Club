package com.ludijf.pongyclub.service;
import com.ludijf.pongyclub.entity.dto.AuthResponseDTO;
import com.ludijf.pongyclub.entity.dto.LoginDTO;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<AuthResponseDTO> login(LoginDTO loginDTO);

}
