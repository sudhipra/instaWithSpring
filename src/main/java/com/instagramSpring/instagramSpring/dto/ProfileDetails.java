package com.instagramSpring.instagramSpring.dto;

import com.instagramSpring.instagramSpring.model.Post;
import com.instagramSpring.instagramSpring.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDetails {
    private User user;
    private List<Post> post;
    private String followers;
    private String following;
}
