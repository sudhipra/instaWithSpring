package com.instagramSpring.instagramSpring.repository;

import com.instagramSpring.instagramSpring.model.Follow;
import com.instagramSpring.instagramSpring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface FollowRepository extends JpaRepository<Follow,Long> {
    @Query(value = "DELETE FROM follow WHERE user_id =?1 And follower_user_id=?2", nativeQuery = true)
    void unfollow(Long userId, Long followerId);
}
