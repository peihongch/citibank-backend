package com.example.ffbackend.rpc;

import com.example.ffbackend.bl.RpcRegularAdjustmentService;

public class RpcRegularAdjustmentServiceImpl implements RpcRegularAdjustmentService {
    @Override
    public boolean stockLeastPosition(String stockCode, int userPosition, int setting) {
        return false;
    }

    @Override
    public boolean stockVolatility(String stockCode, int time, float setting) {
        return false;
    }

    @Override
    public boolean stockChange(String stockCode, int time, float top, float bottom) {
        return false;
    }

    @Override
    public boolean stockMeanReturn(String stockCode, int time, float setting) {
        return false;
    }
}
