package com.example.ffbackend.bl;

import com.example.ffbackend.da.PortfolioDaService;
import com.example.ffbackend.entity.Portfolio;
import com.example.ffbackend.vo.PortfolioVo;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.var;

public class PortfolioService {
    @Autowired
    PortfolioDaService portfolioDaService;

    public int insertPortfolio(PortfolioVo vo) {
        var po =  portfolioDaService.insertPortfolio(Portfolio.fromVo(vo));
        if (po == null) return -1;
        return po.getId();
    }

    public boolean deletePortfolio(int id) {
        portfolioDaService.deletePortfolio(id);
        return true;
    }

    public boolean updatePortfolio(PortfolioVo vo) {
        var po = portfolioDaService.insertPortfolio(Portfolio.fromVo(vo));
        return po != null;
    }

    public PortfolioVo getPortfolio(int id) {
        var po = portfolioDaService.getPortfolio(id);
        if(po == null)
            return null;
        return po.getVo();
    }
}