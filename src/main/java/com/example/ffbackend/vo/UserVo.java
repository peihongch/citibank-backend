package com.example.ffbackend.vo;

import java.util.Date;

import lombok.Data;

@Data
public class UserVo {
    Integer id;
    String username;
    String nickname;
    String gender;
    String birthday;
    String address;
    String password;
    String phone;
    String email;
    String career;
    Integer postnum;
    String signature;

    String emailCaptcha;
    String phoneCaptcha;

    Double fund;
    Long investmentTime;
    Double expectedReturnRate;
    String riskPreference;
    String investmentPreference;
}