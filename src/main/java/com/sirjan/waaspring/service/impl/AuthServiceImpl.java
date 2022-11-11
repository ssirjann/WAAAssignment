package com.sirjan.waaspring.service.impl;

import com.sirjan.waaspring.domain.dto.LoginRequest;
import com.sirjan.waaspring.domain.dto.LoginResponse;
import com.sirjan.waaspring.service.AuthService;
import com.sirjan.waaspring.util.JwtUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;


    public AuthServiceImpl(UserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public LoginResponse login(LoginRequest login) {
        UserDetails user = userDetailsService.loadUserByUsername(login.getUsername());
        return new LoginResponse(jwtUtil.generateToken(user), jwtUtil.generateRefreshToken(user.getUsername()));
    }
}
