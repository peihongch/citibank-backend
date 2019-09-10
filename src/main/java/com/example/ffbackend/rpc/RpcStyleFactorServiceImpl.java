package com.example.ffbackend.rpc;

import com.example.ffbackend.bl.RpcStyleFactorService;

public class RpcStyleFactorServiceImpl implements RpcStyleFactorService {
    @Override
    public float getSize(String tsCode, String fields) {
        return 0;
    }

    @Override
    public float getMomentum(String tsCode) {
        return 0;
    }

    @Override
    public float getBookToMarket(String stockCode) {
        return 0;
    }

    @Override
    public float getLiquidity(String stockCode) {
        return 0;
    }
}
