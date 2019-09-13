package com.example.ffbackend.repo;

import com.example.ffbackend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findPostByUserId(Integer userId);
}