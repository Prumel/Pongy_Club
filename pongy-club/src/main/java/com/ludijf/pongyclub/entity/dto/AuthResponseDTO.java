package com.ludijf.pongyclub.entity.dto;

public class AuthResponseDTO {

    private String accessToken;
    private String tokenType = "Bearer";

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public AuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }
    public AuthResponseDTO(String accessToken, String role) {
        this.accessToken = accessToken;
        this.role = role;
    }

}
