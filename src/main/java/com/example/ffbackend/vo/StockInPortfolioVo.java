package com.example.ffbackend.vo;

import com.example.ffbackend.entity.StockInPortfolio;

import lombok.Data;

@Data
public class StockInPortfolioVo {
    Integer id;
    String code;
    Double num;
    Double money;

    public StockInPortfolio getPo (Integer userId) {
        StockInPortfolio res = new StockInPortfolio();
        res.setId(id);
        res.setUserId(userId);
        res.setCode(code);
        res.setNum(num);
        res.setMoney(money);
        return res;
    }
}