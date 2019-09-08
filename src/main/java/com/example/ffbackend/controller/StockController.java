package com.example.ffbackend.controller;

import com.example.ffbackend.bl.StockService;
import com.example.ffbackend.exception.MyRuntimeException;
import com.example.ffbackend.vo.ResponseBean;
import com.example.ffbackend.vo.ResponseEnums;
import com.example.ffbackend.vo.StockVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.var;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    StockService stockService;

    @GetMapping(value = "/{stock-code}")
    public ResponseBean<StockVo> getStock(@PathVariable("stock-code") String stockCode) {
        var res = stockService.getStockByCode(stockCode);
        if (res == null) throw new MyRuntimeException (ResponseEnums.NO_RECORD, "股票代码不正确");
        return new ResponseBean<>(true, res);
    }
}