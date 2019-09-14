package com.example.ffbackend.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.ffbackend.da.TransactionDaService;
import com.example.ffbackend.entity.Transaction;
import com.example.ffbackend.vo.TradeVo;
import com.example.ffbackend.vo.TransactionVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class TransactionService {
    @Autowired
    TransactionDaService da;

    @Autowired
    StockService stockService;

    public boolean createTransaction(Integer userId, TradeVo vo) {
        var tr = new Transaction(null, new Date(), userId, vo.getCode(), stockService.getStockNameByCode(vo.getCode()),
                vo.getBuy() ? "买入" : "卖出", vo.getNum(), stockService.getStockPriceByCode(vo.getCode()), 4.5);
        da.insertTransaction(tr);
        return true;
    }

    public List<TransactionVo> getTransactions(Integer userId) {
        var pos = da.getTransactionByUserId(userId);
        var vos = new ArrayList<TransactionVo>(pos.size());
        for (var entity : pos)
            vos.add(entity.createVo());
        return vos;
    }
}