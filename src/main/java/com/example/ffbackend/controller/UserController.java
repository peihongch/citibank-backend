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

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public ResponseBean<Object> Register(@RequestBody UserVo vo) {
        // UserVo oriUser = userService.GetUserByUsername(vo.getUsername());
        // if (oriUser!=null)
        //     throw new MyRuntimeException(ResponseEnums.REPEAT_REGISTER);
        userService.InsertUser(vo);
        return new ResponseBean<>(true, null);
    }

    @PutMapping(value = "/{username}")
    public ResponseBean<Object> UpdateUser(@PathVariable("username") String username, @RequestBody UserVo vo) {
        userService.UpdateUser(vo);
        return new ResponseBean<>(true, null);
    }

    @GetMapping(value = "/{username}")
    public ResponseBean<UserVo> GetUser(@PathVariable("username") String username) {
        UserVo userVo = userService.GetUserByUsername(username);
        if (userVo == null)
            throw new MyRuntimeException(ResponseEnums.NO_USER_EXIST);
        return new ResponseBean<>(true, userVo);
    }

    @DeleteMapping(value = "/{username}")
    public ResponseBean<Object> DeleteUser(@PathVariable("username") String username) {
        userService.DeleteUser(username);
        return new ResponseBean<>(true, null);
    }

    @PostMapping(value = "/email-captcha")
    public ResponseBean<Object> CreateEmailCaptcha(@RequestParam(value = "email") String email) {
        userService.InsertEmailCaptcha(email);
        return new ResponseBean<>(true, null);
    }

    @PostMapping(value = "/phone-captcha")
    public ResponseBean<Object> CreatePhoneCaptcha(@RequestParam(value = "phone") String phone) {
        userService.InsertPhoneCaptcha(phone);
        return new ResponseBean<>(true, null);
    }
}