package com.example.ffbackend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.ffbackend.bl.UserService;
import com.example.ffbackend.exception.MyRuntimeException;
import com.example.ffbackend.vo.ResponseBean;
import com.example.ffbackend.vo.ResponseEnums;
import com.example.ffbackend.vo.UserVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.PastOrPresent;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public ResponseBean<Object> register(@RequestBody UserVo vo) {
        userService.insertUser(vo);
        return new ResponseBean<>(true, (Object)null);
    }



    @PutMapping(value = "/{username}")
    public ResponseBean<Object> updateUser(@PathVariable("username") String username, @RequestBody UserVo vo) {
        userService.updateUser(vo);
        return new ResponseBean<>(true, (Object)null);
    }

    @GetMapping(value = "/{username}")
    public ResponseBean<UserVo> getUser(@PathVariable("username") String username) {
        UserVo userVo = userService.getUserByUsername(username);
        if (userVo == null)
            throw new MyRuntimeException(ResponseEnums.NO_USER_EXIST);
        return new ResponseBean<>(true, userVo);
    }

    @DeleteMapping(value = "/{username}")
    public ResponseBean<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return new ResponseBean<>(true, (Object)null);
    }

    @PostMapping(value = "/email-captcha")
    public ResponseBean<Object> createEmailCaptcha(@RequestParam(value = "email") String email) {
        userService.insertEmailCaptcha(email);
        return new ResponseBean<>(true, (Object)null);
    }

    @PostMapping(value = "/phone-captcha")
    public ResponseBean<Object> createPhoneCaptcha(@RequestParam(value = "phone") String phone) {
        userService.insertPhoneCaptcha(phone);
        return new ResponseBean<>(true, (Object)null);
    }
}