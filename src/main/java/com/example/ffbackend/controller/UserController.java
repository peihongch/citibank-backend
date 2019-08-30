package com.example.ffbackend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.ffbackend.viewobject.ResponseBean;
import com.example.ffbackend.viewobject.UserVo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping
    public ResponseBean<Object> Register(@RequestBody UserVo vo) {
        return new ResponseBean<>(true, null);
    }

    @PutMapping
    public ResponseBean<Object> UpdateUser(@RequestBody UserVo vo) {
        return new ResponseBean<>(true, null);
    }

    @GetMapping("/{id}")
    public ResponseBean<UserVo> GetUser(@PathVariable("id") Long id) {
        return new ResponseBean<>(true, new UserVo());
    }

    @DeleteMapping("/{id}")
    public ResponseBean<Object> DeleteUser(@PathVariable("id") Long id) {
        return new ResponseBean<>(true, null);
    }

}