package com.example.ffbackend.da;

import com.example.ffbackend.entity.User;

public interface UserDaService {
    User InsertUser (User user);
    User UpdateUser (User user);
    void DeleteUser (String username);
    User GetUserByUsername (String username);
}