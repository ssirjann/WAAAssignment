package com.sirjan.waaspring.controller.auth;

import com.sirjan.waaspring.domain.dto.LoginRequest;
import com.sirjan.waaspring.domain.dto.LoginResponse;
import com.sirjan.waaspring.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest loginDetails) {
        return authService.login(loginDetails);
    }
}
