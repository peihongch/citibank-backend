package com.example.ffbackend.rpc;

import com.example.ffbackend.bl.RpcAdjustmentAndTriggeringOfPortfolioService;

public class RpcAdjustmentAndTriggeringOfPortfolioServiceImpl implements RpcAdjustmentAndTriggeringOfPortfolioService {
    @Override
    public boolean portFolioVar(String price, float setting) {
        return false;
    }

    @Override
    public boolean stockVolatility(String price, float setting) {
        return false;
    }

    @Override
    public boolean stockDiff(String price, float setting) {
        return false;
    }
}
