package com.example.ffbackend.bl;

import com.example.ffbackend.da.OptionDaService;
import com.example.ffbackend.rpc.RpcOptionFuturesServiceImpl;
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
        
    }
}