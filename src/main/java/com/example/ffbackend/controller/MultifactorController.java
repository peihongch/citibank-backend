package com.example.ffbackend.controller;

import com.example.ffbackend.bl.NewsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.var;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.ffbackend.bl.MultifactorService;
import com.example.ffbackend.vo.MultifactorDetailsVo;
import com.example.ffbackend.vo.NewsVo;
import com.example.ffbackend.vo.ResponseBean;
import com.example.ffbackend.vo.StockTipVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
public class MultifactorController {
    @Autowired
    MultifactorService multifactorService;

    @Autowired
    NewsService newsService;

    @GetMapping(value = "/{user-id}/news")
    public ResponseBean<List<NewsVo>> getNews(@PathVariable("user-id") Integer userId) {
        var newsList =  newsService.getNewsByUserId(userId);
        return new ResponseBean<>(true, newsList);
    }

    @GetMapping(value = "/{user-id}/stock-tips")
    public ResponseBean<List<StockTipVo>> getStockTips(@PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, multifactorService.getStockTips(userId));
    }

    @GetMapping(value = "/{user-id}/multifactor-details")
    public ResponseBean<MultifactorDetailsVo> getMultifactorDetails(@PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, multifactorService.getMultifactorDetails(userId));
    }
}