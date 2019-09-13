package com.example.ffbackend.entity;

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
    String birthday;
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

    public static User fromVo(UserVo vo) {
        User res = new User();
        res.setId(vo.getId());
        res.setUsername(vo.getUsername());
        res.setPassword(vo.getPassword());
        res.setEmail(vo.getEmail());
        res.setPhone(vo.getPhone());
        res.setGender(vo.getGender());
        res.setCareer(vo.getCareer());
        res.setSignature(vo.getSignature());
        res.setFund(vo.getFund());
        res.setInvestmentTime(vo.getInvestmentTime());
        return res;
    }

    public UserVo getVo() {
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