package com.instagramSpring.instagramSpring.controller;

import com.instagramSpring.instagramSpring.model.Post;
import com.instagramSpring.instagramSpring.service.PostimgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@CrossOrigin("http://localhost:4200/")
public class PostimgController {
    @Autowired
    private PostimgService postimgService;

    @PostMapping("/add")
    public ResponseEntity addPostimg(@RequestBody Post post) {
        postimgService.addPostimg(post);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Post>> getAllPostimg() {
        return new ResponseEntity<>(postimgService.getAllPostimg(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Post> getPostimgById(@PathVariable Long id) {
        return new ResponseEntity<>(postimgService.getPostimgById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        postimgService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
