package com.sirjan.waaspring.service.impl;

import com.sirjan.waaspring.domain.dto.LoginRequest;
import com.sirjan.waaspring.domain.dto.LoginResponse;
import com.sirjan.waaspring.service.AuthService;
import com.sirjan.waaspring.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;


    @Override
    public LoginResponse login(LoginRequest login) {
        Authentication response;

        try {
            response = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword())
            );
        } catch (BadCredentialsException e) {
            return new LoginResponse();
        }

        if (response.isAuthenticated()) {

            UserDetails user = userDetailsService.loadUserByUsername(login.getUsername());
            var accessToken = jwtUtil.generateToken(user);
            var refreshToken = jwtUtil.generateRefreshToken(user.getUsername());

            return new LoginResponse(accessToken, refreshToken);
        }

        return null;
    }
}
