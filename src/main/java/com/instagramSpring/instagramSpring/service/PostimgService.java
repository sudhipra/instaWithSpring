package com.instagramSpring.instagramSpring.service;


import com.instagramSpring.instagramSpring.model.Post;
import com.instagramSpring.instagramSpring.repository.PostimgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostimgService {
    @Autowired
    private PostimgRepository postimgRepository;

    @Autowired
    private AuthService authService;

    public void addPostimg(Post post) {
        postimgRepository.save(post);
    }

    public List<Post> getAllPostimg() {
        return postimgRepository.findAll();
    }

    public Post getPostimgById(Long id) {
        return postimgRepository.findById(id).get();
    }

    public void delete(Long id) {
        postimgRepository.deleteById(id);
    }
}
