package com.example.ffbackend.rpc;

import com.example.ffbackend.bl.RpcConditionalTriggerService;
import com.example.ffbackend.rpc.proto.ConditionalTriggerProto.*;
import com.example.ffbackend.rpc.proto.ConditionalTriggerGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RpcConditionalTriggerServiceImpl implements RpcConditionalTriggerService {
    @Autowired
    private ConditionalTriggerGrpc.ConditionalTriggerBlockingStub conditionalTriggerBlockingStub;

    @Override
    public boolean stockTurnoverRate(String stockCode, float top, float bottom) {
        StockTurnoverRateInput.Builder builder = StockTurnoverRateInput.newBuilder();
        builder.setStockCode(stockCode).setTop(top).setBottom(bottom);
        StockTurnoverRateInput stockTurnoverRateInput = builder.build();
        StockTurnoverRateOutput stockTurnoverRateOutput = conditionalTriggerBlockingStub.stockTurnoverRate(stockTurnoverRateInput);
        return stockTurnoverRateOutput.getValue();
    }

    @Override
    public boolean stockMacd(String stockCode, float top, float bottom) {
        StockMacdInput.Builder builder = StockMacdInput.newBuilder();
        builder.setStockCode(stockCode).setTop(top).setBottom(bottom);
        StockMacdInput stockMacdInput  = builder.build();
        StockMacdOutput stockMacdOutput = conditionalTriggerBlockingStub.stockMacd(stockMacdInput);
        return stockMacdOutput.getValue();
    }

    @Override
    public boolean stockRsi(String stockCode, int rsiTime, float top, float bottom) {
        StockRsiInput stockRsiInput = StockRsiInput.newBuilder()
                .setStockCode(stockCode).setRsiTime(rsiTime).setTop(top).setBottom(bottom)
                .build();
        StockRsiOutput stockRsiOutput = conditionalTriggerBlockingStub.stockRsi(stockRsiInput);
        return stockRsiOutput.getValue();
    }

    @Override
    public boolean stockKdj(String stockCode, float K, float D, float J) {
        StockKdjInput stockKdjInput = StockKdjInput.newBuilder()
                .setStockCode(stockCode).setK(K).setD(D).setJ(J)
                .build();
        StockKdjOutput stockKdjOutput = conditionalTriggerBlockingStub.stockKdj(stockKdjInput);
        return stockKdjOutput.getValue();
    }

    @Override
    public boolean stockRoc(String stockCode, int time, float top, float bottom) {
        StockRocInput stockRocInput = StockRocInput.newBuilder()
                .setStockCode(stockCode).setTime(time).setTop(top).setBottom(bottom)
                .build();
        StockRocOutput stockRocOutput = conditionalTriggerBlockingStub.stockRoc(stockRocInput);
        return stockRocOutput.getValue();
    }

    @Override
    public boolean stockSharpe(String stockCode, float setting) {
        StockSharpeInput stockSharpeInput = StockSharpeInput.newBuilder()
                .setStockCode(stockCode).setSetting(setting)
                .build();
        StockSharpeOutput stockSharpeOutput = conditionalTriggerBlockingStub.stockSharpe(stockSharpeInput);
        return stockSharpeOutput.getValue();
    }
}
