package com.example.ffbackend.da;

import com.example.ffbackend.entity.OptionStrategyParams;
import com.example.ffbackend.repo.OptionStrategyParamsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionDaService {
    @Autowired
    OptionStrategyParamsRepo strategyParamRepo;

    public void updateStrategyParams(OptionStrategyParams po) {
        strategyParamRepo.save(po);
    }

    public OptionStrategyParams getStrategyParams(Integer userId) {
        return strategyParamRepo.findById(userId).orElse(null);
    }
}