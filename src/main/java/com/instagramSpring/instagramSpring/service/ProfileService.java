package com.instagramSpring.instagramSpring.service;

import com.instagramSpring.instagramSpring.dto.ProfileDetails;
import com.instagramSpring.instagramSpring.repository.AuthRepository;
import com.instagramSpring.instagramSpring.repository.FollowRepository;
import com.instagramSpring.instagramSpring.repository.PostimgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private PostimgRepository postimgRepository;

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private AuthRepository authRepository;

    public ProfileDetails getProfileDetails(Long id){
        ProfileDetails profileDetails = new ProfileDetails();
        profileDetails.setFollowers(String.valueOf(followRepository.findAll().stream()
                .filter(f->f.getUserid().equals(id.toString()))
                .toList().size()));
        profileDetails.setFollowing(String.valueOf(followRepository.findAll().stream()
                .filter(f->f.getFollowerUserId().equals(id.toString()))
                .toList().size()));
        profileDetails.setUser(authRepository.findById(id).get());
        profileDetails.setPost(postimgRepository.findAll().stream().filter(
                post-> post.getUserId().equals(id.toString())).toList());

        return profileDetails;
    }

}