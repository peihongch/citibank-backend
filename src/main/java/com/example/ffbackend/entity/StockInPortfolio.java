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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer userId;
    String code;
    Double num;
    Double money;

    public StockInPortfolioVo getVo () {
        StockInPortfolioVo res = new StockInPortfolioVo();
        res.setId(id);
        res.setCode(code);
        res.setNum(num);
        res.setMoney(money);
        return res;
    }
}