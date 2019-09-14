package com.example.ffbackend.bl;

import java.util.ArrayList;
import java.util.Date;

import com.example.ffbackend.da.OptionDaService;
import com.example.ffbackend.vo.OptionStrategyParamsVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class OptionService {
    @Autowired
    OptionDaService da;

    @Autowired
    UserService userService;

    @Autowired
    PortfolioService portfolioService;

    @Autowired
    RpcOptionFuturesService rpcOptionFuturesService;

    public void updateOptionStrategyParams(Integer userId, OptionStrategyParamsVo vo) {
        var po = vo.createPo(userId);
        da.updateStrategyParams(po);
    }

    public OptionStrategyParamsVo getOptionStrategyParams(Integer userId) {
        return da.getStrategyParams(userId).createVo();
    }

    @Scheduled(fixedRate = 100000000)
    public void trainPerDay() {
        var allUser = userService.getAllUser();
        for (var user : allUser) {
            var portfolio = portfolioService.getPortfolio(user.getId());
            // TODO: 用户剩余资金
            var assetId = new ArrayList<String>(portfolio.size());
            var assetAmount = new ArrayList<Integer>(portfolio.size());
            for (var p : portfolio) {
                assetId.add(p.getCode());
                assetAmount.add(p.getNum());
            }
            // rpcOptionFuturesService.generateRecommendOptionDelta("", assetId, assetAmount, 0f, new Date());
        }
    }
}
