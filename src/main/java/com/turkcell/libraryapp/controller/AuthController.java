package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.auth.request.LoginRequest;
import com.turkcell.libraryapp.dto.auth.request.RegisterRequest;
import com.turkcell.libraryapp.dto.auth.response.LoginResponse;
import com.turkcell.libraryapp.dto.auth.response.RegisteredResponse;
import com.turkcell.libraryapp.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("register")
    public RegisteredResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("verify-token")
    public Boolean verifyToken(@RequestParam("token") String token){
        return authService.validateToken(token);
    }
}