package com.sirjan.waaspring.domain.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}

