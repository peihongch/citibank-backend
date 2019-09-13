package com.example.ffbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.var;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.ffbackend.vo.MultifactorDetailsVo;
import com.example.ffbackend.vo.NewsVo;
import com.example.ffbackend.vo.ResponseBean;
import com.example.ffbackend.vo.StockTipVo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
public class MultifactorController {
    @GetMapping(value = "/{user-id}/news")
    public ResponseBean<List<NewsVo>> getNews(@PathVariable("user-id") Integer userId) {
        var newsList = new ArrayList<NewsVo>();
        newsList.add(new NewsVo("陶园二舍七楼失火，火势蔓延到食堂", "https://www.baidu.com", new Date()));
        newsList.add(new NewsVo("南大鼓楼校区教学楼爆炸", "https://www.baidu.com", new Date()));
        newsList.add(new NewsVo("鼓楼校区三食堂墙体裂开", "https://www.baidu.com", new Date()));

        return new ResponseBean<>(true, newsList);
    }

    @GetMapping(value = "/{user-id}/stock-tips")
    public ResponseBean<List<StockTipVo>> getStockTips(@PathVariable("user-id") Integer userId) {
        var tips = new ArrayList<StockTipVo>();
        tips.add(new StockTipVo("203040", "南大食堂"));
        tips.add(new StockTipVo("233046", "沛东蟹黄煲"));
        tips.add(new StockTipVo("203040", "黄林动物园"));
        return new ResponseBean<>(true, tips);
    }

    @GetMapping(value = "/{user-id}/multifactor-details")
    public ResponseBean<MultifactorDetailsVo> getMultifactorDetails(@PathVariable("user-id") Integer userId) {
        // TODO: vo没写
        return new ResponseBean<>(true, (MultifactorDetailsVo) null);
    }
}