package com.example.ffbackend.repo;

import com.example.ffbackend.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    void deleteByUsername (String username);
    User findByUsername (String username);
}