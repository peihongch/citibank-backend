package com.example.ffbackend.da;

import com.example.ffbackend.entity.User;
import com.example.ffbackend.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaServiceImpl implements UserDaService {
    @Autowired
    UserRepo userRepo;

    @Override
    public User InsertUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User UpdateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void DeleteUser(String username) {
        userRepo.deleteByUsername(username);
    }

    @Override
    public User GetUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}