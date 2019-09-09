package com.example.ffbackend.vo;

import java.util.List;

import lombok.Data;

@Data
public class PortfolioVo {
    class StockInfo {
        String code;
        Double num;
        Double money;
    }
    Integer id;
    Integer userId;
    List<StockInfo> stockList;
}