package com.example.ffbackend.bl;

import java.util.Date;
import java.util.List;

import com.example.ffbackend.da.TransactionDaService;
import com.example.ffbackend.entity.Transaction;
import com.example.ffbackend.vo.TradeVo;

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
                true, vo.getNum(), stockService.getStockPriceByCode(vo.getCode()), 4.5);
        da.insertTransaction(tr);
        return true;
    }

    public List<Transaction> getTransactions(Integer userId) {
        return da.getTransactionByUserId(userId);
    }
}