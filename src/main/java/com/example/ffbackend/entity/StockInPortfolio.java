package com.example.ffbackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.ffbackend.vo.PortfolioVo;
import com.example.ffbackend.vo.PortfolioVo.StockInPortfolioVo;

import lombok.Data;

@Data
@Entity
@Table
public class StockInPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String code;
    Double num;
    Double money;

    public static StockInPortfolio fromVo (StockInPortfolioVo vo) {
        StockInPortfolio res = new StockInPortfolio();
        res.setId(vo.getId());
        res.setCode(vo.getCode());
        res.setNum(vo.getNum());
        return res;
    }

    public StockInPortfolioVo getVo (PortfolioVo portfolioVo) {
        StockInPortfolioVo res = portfolioVo.new StockInPortfolioVo();
        res.setId(id);
        res.setCode(code);
        res.setNum(num);
        res.setMoney(money);
        return res;
    }
}