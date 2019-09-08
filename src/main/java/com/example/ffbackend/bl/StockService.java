package com.example.ffbackend.bl;

import com.example.ffbackend.vo.StockVo;

public interface StockService {
    StockVo getStockByCode (String code);
}