package com.example.ffbackend.controller;

import com.example.ffbackend.bl.NewsService;
import com.example.ffbackend.bl.RpcStocksService;
import com.example.ffbackend.bl.StockService;
import com.example.ffbackend.exception.MyRuntimeException;
import com.example.ffbackend.vo.NewsVo;
import com.example.ffbackend.vo.ResponseBean;
import com.example.ffbackend.vo.ResponseEnums;
import com.example.ffbackend.vo.StockVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.var;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    StockService stockService;

    @Autowired
    RpcStocksService rpcStocksService;

    @Autowired
    NewsService newsService;

    @GetMapping(value = "/{stock-code}")
    public ResponseBean<List<List<String>>> getStock(@PathVariable("stock-code") String stockCode) {
        var res = rpcStocksService.getStockHistory(stockCode);
        if (res == null) throw new MyRuntimeException (ResponseEnums.NO_RECORD, "股票代码不正确");
        return new ResponseBean<>(true, res);
    }
    @GetMapping(value = "/{stock-code}/news")
    public ResponseBean<List<NewsVo>> getNewsByStockCode(@PathVariable("stock-code") String stockCode){
        var res = newsService.getNewsByStockCode(stockCode);
        if (res == null) throw new MyRuntimeException (ResponseEnums.NO_RECORD, "股票代码不正确");
        return new ResponseBean<>(true,res);
    }
}