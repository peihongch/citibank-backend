package com.example.ffbackend.bl;

import com.example.ffbackend.da.StockDaService;
import com.example.ffbackend.vo.StockVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockDaService stockDaService;
    
    @Override
    public StockVo getStockByCode(String code) {
        
        return null;
    }
}