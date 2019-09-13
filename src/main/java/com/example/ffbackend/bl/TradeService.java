package com.example.ffbackend.bl;

import com.example.ffbackend.da.TransactionDaService;
import com.example.ffbackend.vo.TradeVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService {
    @Autowired
    TransactionDaService da;

    public boolean CreateTrade (Integer userId, TradeVo vo) {
        return true;
    }
}