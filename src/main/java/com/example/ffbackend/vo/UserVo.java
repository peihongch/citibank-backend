package com.example.ffbackend.vo;

import java.util.Date;

import com.example.ffbackend.entity.User;

import lombok.Data;

@Data
public class UserVo {
    Integer id;
    String username;
    String nickname;
    String gender;
    Date birthday;
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
    
    public User getPo() {
        User po = new User();
        po.setId(id);
        po.setUsername(username);
        po.setNickname(nickname);
        po.setGender(gender);
        po.setBirthday(birthday);
        po.setAddress(address);
        po.setEmail(email);
        po.setPhone(phone);
        po.setCareer(career);
        po.setPostnum(postnum);
        po.setSignature(signature);
        po.setFund(fund);
        po.setInvestmentTime(investmentTime);
        po.setExpectedReturnRate(expectedReturnRate);
        po.setRiskPreference(riskPreference);
        return po;
    }
}