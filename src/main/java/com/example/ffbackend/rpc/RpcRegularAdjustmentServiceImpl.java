package com.example.ffbackend.rpc;

import com.example.ffbackend.bl.RpcRegularAdjustmentService;
import com.example.ffbackend.rpc.proto.RegularAdjustmentGrpc;
import com.example.ffbackend.rpc.proto.RegularAdjustmentProto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RpcRegularAdjustmentServiceImpl implements RpcRegularAdjustmentService {
    @Autowired
    private RegularAdjustmentGrpc.RegularAdjustmentBlockingStub regularAdjustmentBlockingStub;

    @Override
    public boolean stockLeastPosition(String stockCode, int userPosition, int setting) {
        StockLeastPositionInput.Builder builder = StockLeastPositionInput.newBuilder();
        builder.setStockCode(stockCode).setUserPosition(userPosition).setSetting(setting);
        StockLeastPositionInput stockLeastPositionInput = builder.build();
        StockLeastPositionOutput stockLeastPositionOutput = regularAdjustmentBlockingStub.stockLeastPosition(stockLeastPositionInput);
        return stockLeastPositionOutput.getValue();
    }

    @Override
    public boolean stockVolatility(String stockCode, int time, float setting) {
        StockVolatilityInput.Builder builder = StockVolatilityInput.newBuilder();
        builder.setStockCode(stockCode).setTime(time).setSetting(setting);
        StockVolatilityInput stockVolatilityInput = builder.build();
        StockVolatilityOutput stockVolatilityOutput = regularAdjustmentBlockingStub.stockVolatility(stockVolatilityInput);
        return stockVolatilityOutput.getValue();
    }

    @Override
    public boolean stockChange(String stockCode, int time, float top, float bottom) {
        StockChangeInput.Builder builder = StockChangeInput.newBuilder();
        builder.setStockCode(stockCode).setTime(time).setTop(top).setBottom(bottom);
        StockChangeInput stockChangeInput = builder.build();
        StockChangeOutput stockChangeOutput = regularAdjustmentBlockingStub.stockChange(stockChangeInput);
        return stockChangeOutput.getValue();
    }

    @Override
    public boolean stockMeanReturn(String stockCode, int time, float setting) {
        StockMeanReturnInput.Builder builder = StockMeanReturnInput.newBuilder();
        builder.setStockCode(stockCode).setTime(time).setSetting(setting);
        StockMeanReturnInput stockMeanReturnInput = builder.build();
        StockMeanReturnOutput stockMeanReturnOutput = regularAdjustmentBlockingStub.stockMeanReturn(stockMeanReturnInput);
        return stockMeanReturnOutput.getValue();
    }
}
