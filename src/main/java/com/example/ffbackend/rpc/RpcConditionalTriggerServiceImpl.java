package com.example.ffbackend.rpc;

import com.example.ffbackend.bl.RpcConditionalTriggerService;

public class RpcConditionalTriggerServiceImpl implements RpcConditionalTriggerService {
    @Override
    public boolean stockTurnoverRate(String stockCode, float top, float bottom) {
        return false;
    }

    @Override
    public boolean stockMacd(String stockCode, float top, float bottom) {
        return false;
    }

    @Override
    public boolean stockRsi(String stockCode, int rsiTime, float top, float bottom) {
        return false;
    }

    @Override
    public boolean stockKdj(String stockCode, float K, float D, float J) {
        return false;
    }

    @Override
    public boolean stockRoc(String stockCode, int time, float top, float bottom) {
        return false;
    }

    @Override
    public boolean stockSharpe(String stockCode, float setting) {
        return false;
    }
}
