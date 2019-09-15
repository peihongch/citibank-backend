package com.example.ffbackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.ffbackend.vo.StockInPortfolioVo;

import lombok.Data;

@Data
@Entity
@Table
public class StockInPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Integer id;

    String code;

    Integer userId;
    Integer num;
    Double money;

    public StockInPortfolioVo getVo () {
        StockInPortfolioVo res = new StockInPortfolioVo();
        res.setCode(code);
        res.setNum(num);
        res.setMoney(money);
        return res;
    }
}