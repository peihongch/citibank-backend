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

    public MultifactorDetailsVo getMultifactorDetails(Integer userId) {
        // TODO: 对接rpc

        MultifactorDetailsVo res = new MultifactorDetailsVo(30020.5, 10000.0, null);
        var portfolio = portfolioService.getPortfolio(userId);
        List<MultifactorDatasetVo> multifactorDatasets = new ArrayList<MultifactorDatasetVo>(portfolio.size());
        for (var stockInPortfolio : portfolio)
            multifactorDatasets
                    .add(res.new MultifactorDatasetVo(stockService.getStockNameByCode(stockInPortfolio.getCode()),
                            stockInPortfolio.getCode(), new HashMap<String, Double>() {
								private static final long serialVersionUID = 3126410076252489098L;
								{
                                    put("牛逼因子", 15.2);
                                    put("潮汕牛肉丸因子", 23.5);
                                    put("海绵宝宝因子", 15.3);
                                    put("美人鱼战士与企鹅男孩", 2.4);
                                }
                            }, stockService.getStockPriceByCode(stockInPortfolio.getCode()), stockInPortfolio.getNum(),
                            500));

        res.setDataSource(multifactorDatasets);
        return res;
    }
}
