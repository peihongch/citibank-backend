package com.example.ffbackend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.ffbackend.viewobject.ResponseBean;
import com.example.ffbackend.viewobject.UserForSessionVo;
import com.example.ffbackend.viewobject.UserVo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
    @RequestMapping(value="/user", method=RequestMethod.POST)
    public ResponseBean<Object> requestMethodName(@RequestBody UserVo vo) {
        return new ResponseBean<>(true, null);
    }

    @RequestMapping(value="/user/session", method=RequestMethod.POST)
    public ResponseBean<String> requestMethodName(@RequestBody UserForSessionVo vo) {
        return new ResponseBean<>(true, "sample_session");
    }

    @RequestMapping(value="/user/session", method=RequestMethod.DELETE)
    public ResponseBean<Object> uestMethodName(@RequestParam String token) {
        return new ResponseBean<>(true, null);
    }
    
}