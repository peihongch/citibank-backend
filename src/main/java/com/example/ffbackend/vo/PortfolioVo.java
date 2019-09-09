package com.example.ffbackend.vo;

import java.util.List;

import lombok.Data;

@Data
public class PortfolioVo {
    @Data
    public class StockInPortfolioVo {
        Integer id;
        String code;
        Double num;
        Double money;
    }
    Integer id;
    Integer userId;
    List<StockInPortfolioVo> stockList;
}