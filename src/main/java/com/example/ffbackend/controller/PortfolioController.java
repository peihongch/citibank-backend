package com.example.ffbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import com.example.ffbackend.bl.PortfolioService;
import com.example.ffbackend.vo.ResponseBean;
import com.example.ffbackend.vo.StockInPortfolioVo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/user")
public class PortfolioController {
    @Autowired
    PortfolioService bl;

    @PostMapping(value = "/{user-id}/stock-in-portfolio")
    public ResponseBean<Object> createPortfolio(@PathVariable("user-id") Integer userId, @RequestBody StockInPortfolioVo vo) {
        bl.insertPortfolio(userId, vo);
        return new ResponseBean<>(true, (Object)null);
    }

    @GetMapping(value = "/{user-id}/stock-in-portfolio")
    public ResponseBean<List<StockInPortfolioVo>> getPortfolio(@PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, bl.getPortfolio(userId));
    }

    @GetMapping(value="/{user-id}/portfolio-price")
    public ResponseBean<Map<String, Integer>> getPortfolioCurrentPrice(@PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, bl.getPortfolioCurrentPrice(userId));
    }
    

    @DeleteMapping(value = "/{user-id}/stock-in-portfolio/{id}")
    public ResponseBean<Object> deletePortfolio(@PathVariable("user-id") Integer userId, @PathVariable("id") Integer id) {
        bl.deletePortfolio(id);
        return new ResponseBean<>(true, null);
    }

    @PutMapping(value = "/{user-id}/stock-in-portfolio/{id}")
    public ResponseBean<Object> updatePortfolio(@PathVariable("user-id") Integer userId, @RequestBody StockInPortfolioVo vo) {
        bl.updatePortfolio(userId, vo);
        return new ResponseBean<>(true, null);
    }
}