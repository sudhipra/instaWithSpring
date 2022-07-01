package com.instagramSpring.instagramSpring.repository;

import com.instagramSpring.instagramSpring.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostimgRepository extends JpaRepository<Post,Long> {
}
