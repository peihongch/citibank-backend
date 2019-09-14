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

    public User InsertUser(User user) {
        return userRepo.save(user);
    }

    public User UpdateUser(User user) {
        return userRepo.save(user);
    }

    public void DeleteUser(String username) {
        userRepo.deleteByUsername(username);
    }

    public User GetUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }
}