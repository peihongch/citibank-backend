package com.example.ffbackend.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.ffbackend.da.TransactionDaService;
import com.example.ffbackend.entity.Transaction;
import com.example.ffbackend.vo.TransactionVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class TransactionService {
    @Autowired
    TransactionDaService da;

    public boolean createTransaction(Integer userId, String code, String stockName, Boolean buy, Integer num, Double price, Double commission) {
        var tr = new Transaction(null, new Date(), userId, code, stockName, buy ? "买入" : "卖出", num, price, commission);
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
