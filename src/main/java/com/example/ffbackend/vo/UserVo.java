package com.example.ffbackend.vo;

import java.util.Date;

import lombok.Data;

@Data
public class UserVo {
    Integer id;
    String username;
    String password;
    String email;
    String emailCaptcha;
    String phone;
    String phoneCaptcha;
    Boolean gender;
    Date birthday;
    String career;
    String signature;
    Double fund;
    Long investmentTime;
    Double expectedReturnRate;
    String riskPreference;
    String investmentPreference;
    String address;
}