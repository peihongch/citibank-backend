package com.example.ffbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ffbackend.bl.ChargeService;
import com.example.ffbackend.vo.ChargeVo;
import com.example.ffbackend.vo.ResponseBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class ChargeController {
    @Autowired
    ChargeService service;

    @PostMapping(value = "/{user-id}/charge")
    public ResponseBean<Object> postCharge(@PathVariable("user-id") Integer userId, @RequestBody ChargeVo vo) {
        service.createCharge(userId, vo);
        return new ResponseBean<>(true, (Object) null);
    }
}