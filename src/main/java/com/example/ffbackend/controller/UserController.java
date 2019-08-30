package com.example.ffbackend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.ffbackend.viewobject.ResponseBean;
import com.example.ffbackend.viewobject.UserQuestionnaireVo;
import com.example.ffbackend.viewobject.UserVo;

import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseBean<Object> Register(@RequestBody UserVo vo) {
        return new ResponseBean<>(true, null);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseBean<UserVo> GetUser(@PathVariable Long id) {
        return new ResponseBean<>(true, new UserVo());
    }

    @RequestMapping(value = "/user/session", method = RequestMethod.POST)
    public ResponseBean<Pair<Long, String>> Login(@RequestParam(value = "username") String username,
            @RequestParam(value = "pwd") String pwd) {
        return new ResponseBean<Pair<Long, String>>(true, Pair.of(23333L, "sample_token"));
    }

    @RequestMapping(value = "/user/session/{id}", method = RequestMethod.DELETE)
    public ResponseBean<Object> Logout(@PathVariable Long id) {
        return new ResponseBean<>(true, null);
    }

    @RequestMapping(value = "/user/questionnaire", method = RequestMethod.PUT)
    public ResponseBean<Object> UpdateQuestionnaire(@RequestBody UserQuestionnaireVo vo) {
        return new ResponseBean<>(true, null);
    }

}