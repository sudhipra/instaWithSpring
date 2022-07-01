package com.instagramSpring.instagramSpring.service;

import com.instagramSpring.instagramSpring.model.Follow;
import com.instagramSpring.instagramSpring.model.User;
import com.instagramSpring.instagramSpring.repository.AuthRepository;
import com.instagramSpring.instagramSpring.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowService {
    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private AuthRepository authRepository;
    public void follow(Long userId, Long followerId) {
        Follow follow = new Follow();
        follow.setFollowerUserId(followerId);
        follow.setUserid(userId);
        followRepository.save(follow);
    }
    public void unfollow(Long userId, Long followerId) {
        followRepository.unfollow(userId,followerId);
    }

    public List<User> followers(Long userId) {
        List<User> userList = new ArrayList<>();
        List<Follow> follows =  followRepository.findAll().stream()
                .filter(f->f.getUserid().equals(userId.toString()))
                .toList();

        follows.forEach(f->{
           User u = authRepository.findById(f.getFollowerUserId()).get();
           userList.add(u);
        });

        return userList;
    }
    public List<User> following(Long userId) {
        List<User> userList = new ArrayList<>();
        List<Follow> follows =  followRepository.findAll().stream()
                .filter(f->f.getFollowerUserId().equals(userId.toString()))
                .toList();

        follows.forEach(f->{
            User u = authRepository.findById(f.getFollowerUserId()).get();
            userList.add(u);
        });

        return userList;
    }
}
