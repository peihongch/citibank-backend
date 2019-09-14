package com.example.ffbackend.controller;

import com.example.ffbackend.bl.SessionService;
import com.example.ffbackend.vo.ResponseBean;
import com.example.ffbackend.vo.SessionVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/session")
public class SessionController {
    @Autowired
    SessionService service;

    @PostMapping
    public ResponseBean<SessionVo> createSession(@RequestParam(value = "username") String username,
            @RequestParam(value = "pwd") String pwd) {
        return new ResponseBean<SessionVo>(true, service.createSession(username, pwd));
    }

    @DeleteMapping(value = "/{session}")
    public ResponseBean<Object> deleteSession(@PathVariable("session") String session) {
        service.removeSession(session);
        return new ResponseBean<>(true, null);
    }
}