package com.example.ffbackend.bl;

import java.util.Random;

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
        Random rand = new Random();
        return (rand.nextInt(60) + 600) / 100.0;
    }
}

