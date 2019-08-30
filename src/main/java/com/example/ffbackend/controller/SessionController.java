package com.example.ffbackend.controller;

import com.example.ffbackend.viewobject.ResponseBean;

import org.springframework.data.util.Pair;
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
    public ResponseBean<Pair<Long, String>> Login(@RequestParam(value = "username") String username,
            @RequestParam(value = "pwd") String pwd) {
        return new ResponseBean<Pair<Long, String>>(true, Pair.of(23333L, "sample_token"));
    }

    @DeleteMapping("/{token}")
    public ResponseBean<Object> Logout(@PathVariable("token") String token) {
        return new ResponseBean<>(true, null);
    }
}