package com.example.ffbackend.bl;

import com.example.ffbackend.vo.StockVo;

import org.springframework.stereotype.Service;

@Service
public class StockService {
    public StockVo getStockByCode(String code) {
        return null;
    }

    public String getStockNameByCode(String code) {
        return "花旗银行";
    }

    public Double getStockPriceByCode (String code) {
        return 6.05;
    }
}