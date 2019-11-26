package com.example.ffbackend.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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

    @Autowired
    RpcStyleFactorService rpcStyleFactorService;

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

        MultifactorDetailsVo res = new MultifactorDetailsVo(30020.5, 0.6, null);
        var portfolio = portfolioService.getPortfolio(userId);
        List<MultifactorDatasetVo> multifactorDatasets = new ArrayList<MultifactorDatasetVo>(portfolio.size());

        var factors = new ArrayList<HashMap<String, Double>>() {
            private static final long serialVersionUID = 3126410076252489098L;
            {
                add(new HashMap<String, Double>() {
                    private static final long serialVersionUID = 3126410076252489098L;
                    {
                        put("牛逼", 15.2);

                    }
                });
                add(new HashMap<String, Double>() {
                    private static final long serialVersionUID = 3126410076252489098L;
                    {
                        put("牛逼", 10.2);
                    }
                });
                add(new HashMap<String, Double>() {
                    private static final long serialVersionUID = 3126410076252489098L;
                    {
                        put("牛逼", 6.2);
                    }
                });
                add(new HashMap<String, Double>() {
                    private static final long serialVersionUID = 3126410076252489098L;
                    {
                        put("潮牛丸", 23.5);
                        put("美与男", 2.4);
                    }
                });
                add(new HashMap<String, Double>() {
                    private static final long serialVersionUID = 3126410076252489098L;
                    {
                        put("海绵宝", 15.3);
                    }
                });
            }
        };
        Random rand = new Random();

        for (var stockInPortfolio : portfolio)
            multifactorDatasets.add(res.new MultifactorDatasetVo(
                    stockService.getStockNameByCode(stockInPortfolio.getCode()), stockInPortfolio.getCode(),
                    factors.get(rand.nextInt(factors.size())),
                    stockService.getStockPriceByCode(stockInPortfolio.getCode()), stockInPortfolio.getNum(), 500));

        res.setDataSource(multifactorDatasets);
        return res;
    }
}
