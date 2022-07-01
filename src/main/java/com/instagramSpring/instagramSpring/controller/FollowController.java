package com.instagramSpring.instagramSpring.controller;

import com.instagramSpring.instagramSpring.dto.AuthenticationResponse;
import com.instagramSpring.instagramSpring.dto.LoginRequest;
import com.instagramSpring.instagramSpring.dto.ProfileDetails;
import com.instagramSpring.instagramSpring.dto.RegisterRequest;
import com.instagramSpring.instagramSpring.model.Post;
import com.instagramSpring.instagramSpring.model.User;
import com.instagramSpring.instagramSpring.service.AuthService;
import com.instagramSpring.instagramSpring.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FollowController {
    @Autowired
    private FollowService followService;

    @GetMapping("/follow/{userId}/{followerId}")
    public ResponseEntity follow(@PathVariable Long userId,@PathVariable Long followerId) {
        followService.follow(userId,followerId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/followers/{userId}")
    public List<User> followers(@PathVariable Long userId) {
        return followService.followers(userId);
    }

    @GetMapping("/following/{userId}")
    public  List<User> following(@PathVariable Long userId) {
        return followService.following(userId);
    }

    @DeleteMapping("/unfollow/{userId}/{followerId}")
    public ResponseEntity unfollow(@PathVariable Long userId,@PathVariable Long followerId) {
        followService.unfollow(userId,followerId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
