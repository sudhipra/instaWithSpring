package com.instagramSpring.instagramSpring.controller;

import com.instagramSpring.instagramSpring.dto.AuthenticationResponse;
import com.instagramSpring.instagramSpring.dto.LoginRequest;
import com.instagramSpring.instagramSpring.dto.ProfileDetails;
import com.instagramSpring.instagramSpring.dto.RegisterRequest;
import com.instagramSpring.instagramSpring.service.AuthService;
import com.instagramSpring.instagramSpring.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/profile]")
@CrossOrigin("http://localhost:4200/")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping("/{id}")
    public ProfileDetails register(@PathVariable Long id) {
       return  profileService.getProfileDetails(id);
    }
}




