package com.example.ffbackend.vo;

import com.example.ffbackend.entity.StockInPortfolio;

import lombok.Data;

@Data
public class StockInPortfolioVo {
    String code;
    Integer num;
    Double money;

    public StockInPortfolio createPo (Integer userId) {
        StockInPortfolio res = new StockInPortfolio();
        res.setUserId(userId);
        res.setCode(code);
        res.setNum(num);
        res.setMoney(money);
        return res;
    }
}