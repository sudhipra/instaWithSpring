package com.instagramSpring.instagramSpring.controller;

import com.instagramSpring.instagramSpring.dto.AuthenticationResponse;
import com.instagramSpring.instagramSpring.dto.LoginRequest;
import com.instagramSpring.instagramSpring.dto.RegisterRequest;
import com.instagramSpring.instagramSpring.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:4200/")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest registerRequest) {
        authService.register(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}