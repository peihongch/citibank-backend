package com.example.ffbackend.da;

import java.util.List;

import com.example.ffbackend.entity.User;
import com.example.ffbackend.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaService {
    @Autowired
    UserRepo userRepo;

    public User insertUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(String username) {
        userRepo.deleteByUsername(username);
    }

    public User getUserById (Integer id) {
        return userRepo.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }
}