package com.example.ffbackend.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ffbackend.da.PortfolioDaService;
import com.example.ffbackend.entity.StockInPortfolio;
import com.example.ffbackend.exception.MyRuntimeException;
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

    @Autowired
    UserService userService;

    @Autowired
    TransactionService transactionService;

    public boolean deletePortfolio(int id) {
        da.deletePortfolio(id);
        return true;
    }

    public void updatePortfolio(Integer userId, List<StockInPortfolioVo> vo) {
        var oriPortfolio = da.getPortfolioByUserId(userId);
        Map<String, StockInPortfolio> oriPflMap = new HashMap<>();
        for (var stk : oriPortfolio)
            oriPflMap.put(stk.getCode(), stk);
        for (var stk : vo) {
            var oriStk = oriPflMap.get(stk.getCode());
            if (oriStk == null) {
                // 购入新股票
            } else {
                if (oriStk.getNum() == stk.getNum())
                    continue;
                if (oriStk.getNum() < stk.getNum()) {
                    var buyNum = stk.getNum() - oriStk.getNum();
                    transactionService.createTransaction(userId, stk.getCode(),
                            stockService.getStockNameByCode(stk.getCode()), true, buyNum,
                            stockService.getStockPriceByCode(stk.getCode()), 2.03);
                } else {
                    var sellNum = oriStk.getNum() - stk.getNum();
                    transactionService.createTransaction(userId, stk.getCode(),
                            stockService.getStockNameByCode(stk.getCode()), false, sellNum,
                            stockService.getStockPriceByCode(stk.getCode()), 2.03);
                }
                da.updatePortfolio(stk.createPo(userId));
            }
        }
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