package com.example.ffbackend.controller;

import com.example.ffbackend.viewobject.ResponseBean;

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
    public ResponseBean<String> CreateSession(@RequestParam(value = "username") String username,
            @RequestParam(value = "pwd") String pwd) {
        return new ResponseBean<String>(true, "sample_token");
    }

    @DeleteMapping("/{session}")
    public ResponseBean<Object> DeleteSession(@PathVariable("session") String session) {
        return new ResponseBean<>(true, null);
    }
}