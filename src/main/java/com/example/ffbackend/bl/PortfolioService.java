package com.example.ffbackend.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ffbackend.da.PortfolioDaService;
import com.example.ffbackend.exception.MyRuntimeException;
import com.example.ffbackend.vo.ResponseEnums;
import com.example.ffbackend.vo.StockInPortfolioVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class PortfolioService {

    @Autowired
    PortfolioDaService da;

    @Autowired
    StockService stockService;

    public int insertPortfolio(Integer userId, StockInPortfolioVo vo) {
        vo.setMoney(stockService.getStockPriceByCode(vo.getCode()));
        var po = da.insertPortfolio(vo.createPo(userId));
        if (po == null)
            throw new MyRuntimeException(ResponseEnums.DATABASE_ERROR);
        return po.getId();
    }

    public boolean deletePortfolio(int id) {
        da.deletePortfolio(id);
        return true;
    }

    public boolean updatePortfolio(Integer userId, StockInPortfolioVo vo) {
        var po = da.insertPortfolio(vo.createPo(userId));
        return po != null;
    }

    public List<StockInPortfolioVo> getPortfolio(int userId) {
        var pos = da.getPortfolioByUserId(userId);
        if (pos == null)
            throw new MyRuntimeException();
        var vos = new ArrayList<StockInPortfolioVo>(pos.size());
        for (var po : pos)
            vos.add(po.getVo());
        return vos;
    }

    public Map<String, Double> getPortfolioCurrentPrice(int userId) {
        var pos = da.getPortfolioByUserId(userId);
        HashMap<String, Double> res = new HashMap<>();
        for (var po : pos)
            res.put(po.getCode(), stockService.getStockPriceByCode(po.getCode()));
        return res;
    }
}