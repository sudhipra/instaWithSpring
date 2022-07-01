package com.instagramSpring.instagramSpring.repository;

import com.instagramSpring.instagramSpring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<User,Long> {
}
