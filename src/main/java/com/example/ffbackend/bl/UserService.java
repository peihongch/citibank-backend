package com.example.ffbackend.bl;

import com.example.ffbackend.vo.UserVo;

public interface UserService {
    boolean InsertUser(UserVo vo);

    boolean DeleteUser(String username);

    boolean UpdateUser(UserVo vo);

    UserVo GetUserByUsername(String username);

    boolean InsertEmailCaptcha(String email);

    boolean InsertPhoneCaptcha(String phone);
}