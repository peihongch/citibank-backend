package com.example.ffbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ffbackend.vo.ResponseBean;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
public class MultifactorController {
    @GetMapping(value = "/{user-id}/multifactor-details")
    public ResponseBean<Object> getMultifactorDetails(@PathVariable("user-id") Integer userId, @RequestParam("code") String[] codes, @RequestParam("share") Double[] shares) {
        // TODO: vo没写
        return new ResponseBean<>(true, (Object) null);
    }

    @GetMapping(value="/{user-id}/news")
    public ResponseBean<Object> getNews(@PathVariable("user-id") Integer userId) {
        // TODO: vo没写
        return new ResponseBean<>(true, (Object) null);
    }

    @GetMapping(value="/{user-id}/stock-tips")
    public ResponseBean<Object> getStockTips(@PathVariable("user-id") Integer userId) {
        // TODO: vo没写
        return new ResponseBean<>(true, (Object) null);
    }

    @GetMapping(value="/{user-id}/multifactor-recommend")
    public ResponseBean<Object> getMultifactorRecommend(@PathVariable("user-id") Integer userId) {
        // TODO: vo没写
        return new ResponseBean<>(true, (Object) null);
    }
}