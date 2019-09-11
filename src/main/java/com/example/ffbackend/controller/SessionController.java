package com.example.ffbackend.controller;

import com.example.ffbackend.vo.ResponseBean;
import com.example.ffbackend.vo.SessionVo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/session")
public class SessionController {
    @PostMapping
    public ResponseBean<SessionVo> createSession(@RequestParam(value = "username") String username,
            @RequestParam(value = "pwd") String pwd) {
        // TODO: 判断用户密码(用MD5??)正确，获取session库
        return new ResponseBean<SessionVo>(true, new SessionVo("session", -1));
    }

    @DeleteMapping(value = "/{session}")
    public ResponseBean<Object> deleteSession(@PathVariable("session") String session) {
        // TODO: 利用Session库用户登出
        return new ResponseBean<>(true, null);
    }
}