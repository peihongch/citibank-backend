package com.example.ffbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ffbackend.bl.TradeService;
import com.example.ffbackend.vo.ResponseBean;
import com.example.ffbackend.vo.TradeVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class TradeController {
    @Autowired
    TradeService bl;

    @PostMapping(value = "/{user-id}/trade")
    public ResponseBean<Object> postTrade(@RequestBody TradeVo vo) {
        bl.CreateTrade(vo);
        return new ResponseBean<>(true, (Object) null);
    }

}