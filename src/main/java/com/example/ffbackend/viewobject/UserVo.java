package com.example.ffbackend.viewobject;

import java.util.Date;

import lombok.Data;

@Data
public class UserVo {
    String username;
    String password;
    String email;
    String phone;
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