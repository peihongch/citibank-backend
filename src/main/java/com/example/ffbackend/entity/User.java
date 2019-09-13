package com.example.ffbackend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.ffbackend.vo.UserVo;

import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String username;
    String password;
    String nickname;
    String gender;
    Date birthday;
    String address;
    String phone;
    String email;
    String career;
    Integer postnum;
    String signature;

    Double fund;
    Long investmentTime;
    Double expectedReturnRate;
    String riskPreference;
    String investmentPreference;

    public UserVo createVo() {
        UserVo vo = new UserVo();
        vo.setId(id);
        vo.setUsername(username);
        vo.setNickname(nickname);
        vo.setGender(gender);
        vo.setBirthday(birthday);
        vo.setAddress(address);
        vo.setEmail(email);
        vo.setPhone(phone);
        vo.setCareer(career);
        vo.setPostnum(postnum);
        vo.setSignature(signature);
        vo.setFund(fund);
        vo.setInvestmentTime(investmentTime);
        vo.setExpectedReturnRate(expectedReturnRate);
        vo.setRiskPreference(riskPreference);
        return vo;
    }
}