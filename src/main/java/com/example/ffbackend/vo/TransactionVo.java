package com.example.ffbackend.vo;

import java.util.Date;

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
}