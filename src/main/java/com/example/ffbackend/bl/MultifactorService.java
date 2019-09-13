package com.example.ffbackend.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.ffbackend.vo.MultifactorDetailsVo;
import com.example.ffbackend.vo.StockTipVo;
import com.example.ffbackend.vo.MultifactorDetailsVo.MultifactorDatasetVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class MultifactorService {
    @Autowired
    PortfolioService portfolioService;

    @Autowired
    StockService stockService;

    public List<StockTipVo> getStockTips(Integer userId) {
        // TODO: 对接rpc
        var tips = new ArrayList<StockTipVo>();
        tips.add(new StockTipVo("203040", "南大食堂"));
        tips.add(new StockTipVo("233046", "沛东蟹黄煲"));
        tips.add(new StockTipVo("420300", "黄林动物园"));
        return tips;
    }

    public MultifactorDetailsVo getMultifactorDetails (Integer userId) {
        // TODO: 对接rpc

        MultifactorDetailsVo res = new MultifactorDetailsVo(30020.5, 10000.0, null);
        var portfolio = portfolioService.getPortfolio(userId);
        List<MultifactorDatasetVo> multifactorDatasets = new ArrayList<MultifactorDatasetVo>(portfolio.size());
        for (var stockInPortfolio : portfolio)
            multifactorDatasets.add(res.new MultifactorDatasetVo(stockService.getStockNameByCode(stockInPortfolio.getCode()), stockInPortfolio.getCode(), new HashMap<String, Double>(), stockService.getStockPriceByCode(stockInPortfolio.getCode()), stockInPortfolio.getNum(), 500));

        res.setDataSource(multifactorDatasets);
        return res;
    }
}
