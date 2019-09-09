package com.example.ffbackend.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.ffbackend.vo.PortfolioVo;
import com.example.ffbackend.vo.PortfolioVo.StockInPortfolioVo;

import lombok.Data;
import lombok.var;

@Entity
@Table(name = "portfolio")
@Data
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @JoinColumn(name = "portfolio_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<StockInPortfolio> stocks;

    public static Portfolio fromVo(PortfolioVo vo) {
        Portfolio res = new Portfolio();
        res.setId(vo.getId());
        var stockVos = vo.getStockList();
        var stockPos = new ArrayList<StockInPortfolio>(stockVos.size());
        for (var item : stockVos)
            stockPos.add(StockInPortfolio.fromVo(item));
        res.setStocks(stockPos);
        return res;
    }

    public PortfolioVo getVo () {
        PortfolioVo res = new PortfolioVo();
        res.setId(id);
        var stockVos = new ArrayList<StockInPortfolioVo> (stocks.size());
        for (var item : stocks)
            stockVos.add(item.getVo(res));
        res.setStockList(stockVos);
        return res;
    }
}