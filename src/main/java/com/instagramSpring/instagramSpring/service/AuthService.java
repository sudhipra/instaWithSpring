package com.instagramSpring.instagramSpring.service;

import com.instagramSpring.instagramSpring.dto.AuthenticationResponse;
import com.instagramSpring.instagramSpring.dto.LoginRequest;
import com.instagramSpring.instagramSpring.dto.RegisterRequest;
import com.instagramSpring.instagramSpring.model.User;
import com.instagramSpring.instagramSpring.repository.AuthRepository;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    public void register(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setImg(registerRequest.getImg());
        user.setPassword(registerRequest.getPassword());
        authRepository.save(user);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
       User loggedInUser = authRepository.findAll().stream().filter(u-> u.getUsername()
                .equals(loginRequest.getUsername()) && u.getPassword()
                .equals(loginRequest.getPassword())).findFirst().get();

        return new AuthenticationResponse(loggedInUser.getId(),
                authRepository.findAll().stream().anyMatch(user-> user.getUsername()
                        .equals(loginRequest.getUsername()) && user.getPassword()
                        .equals(loginRequest.getPassword())));
    }
}