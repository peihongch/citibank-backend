package com.example.ffbackend.controller;

import com.example.ffbackend.vo.ResponseBean;
import com.example.ffbackend.vo.TransactionVo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class InvestmentHistoryController {
    /**
     * 获取累计波动率
     */
    @GetMapping(value = "/{user-id}/accumulated-volatility")
    public ResponseBean<Double> getAccumulatedVolatility(@PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, -1.0);
    }

    /**
     * 获取累计回报率
     */
    @GetMapping(value = "/{user-id}/accumulated-return-rate")
    public ResponseBean<Double> getAccumulatedReturnRate(@PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, -1.0);
    }

    /**
     * 获取累计收益
     */
    @GetMapping(value = "/{user-id}/accumulated-gains")
    public ResponseBean<Double> getAccumulatedGains(@PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, -1.0);
    }

    /**
     * sharp比
     */
    @GetMapping(value = "/{user-id]/sharp-ratio")
    public ResponseBean<Double> getSharpRatio(@PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, -1.0);
    }


    /**
     * 获取累计历史记录
     */
    @GetMapping(value = "/{user-id}/transacion-history")
    public ResponseBean<TransactionVo> getAccumulatedHistory(@PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, new TransactionVo());
    }
}