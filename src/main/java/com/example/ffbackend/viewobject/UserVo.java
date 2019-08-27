package com.example.ffbackend.viewobject;

import lombok.Data;

@Data
public class UserVo {
    String username;
    String password;
    String email;
    String phone;
}