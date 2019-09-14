package com.example.ffbackend.vo;

import java.util.Date;

import com.example.ffbackend.entity.Transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionVo {
    Date date;
    String code;
    String name;
    String genre; // 交易类型
    Integer quantity;
    Double price; // 单价
    Double cost; // 总价
    Double commission;

    public Transaction createVo(Integer userId) {
        return new Transaction(null, date, userId, code, name, genre, quantity, price, commission);
    }
}