package com.sirjan.waaspring.service;

import com.sirjan.waaspring.domain.dto.LoginRequest;
import com.sirjan.waaspring.domain.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest login);
}
