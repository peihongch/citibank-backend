package com.example.ffbackend.vo;

import java.util.Date;

import com.example.ffbackend.entity.Transaction;

import lombok.Data;

@Data
public class TransactionVo {
    Date date;
    String code;
    String name;
    String genre; // 交易类型
    Integer quantity;
    Double price; // 单价
    Double cost; // 总价
    Double commission;

    public static TransactionVo createVo(Transaction po) {
        TransactionVo res = new TransactionVo();
        res.setDate(po.getDate());
        res.setCode(po.getCode());
        res.setName(po.getName());
        res.setGenre(po.getBuy() ? "买入" : "卖出");
        res.setQuantity(po.getQuantity());
        res.setPrice(po.getPrice());
        res.setCost(res.getPrice() * res.getQuantity());
        res.setCommission(res.getCommission());
        return res;
    }
}