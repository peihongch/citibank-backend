package com.example.ffbackend;

import com.example.ffbackend.rpc.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;

public class RpcTest {
    private String host = "111.231.121.238";
    private int port = 50051;

    public RpcTest() {
    }

    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    }

    public RegularAdjustmentGrpc.RegularAdjustmentBlockingStub regularAdjustmentBlockingStub() {
        return RegularAdjustmentGrpc.newBlockingStub(managedChannel());
    }

    public AdjustmentAndTriggeringOfPortfolioGrpc.AdjustmentAndTriggeringOfPortfolioBlockingStub adjustmentAndTriggeringOfPortfolioBlockingStub() {
        return AdjustmentAndTriggeringOfPortfolioGrpc.newBlockingStub(managedChannel());
    }

    public CitibankApiGrpc.CitibankApiBlockingStub citibankApiBlockingStub() {
        return CitibankApiGrpc.newBlockingStub(managedChannel());
    }

    public ConditionalTriggerGrpc.ConditionalTriggerBlockingStub conditionalTriggerBlockingStub(){
        return ConditionalTriggerGrpc.newBlockingStub(managedChannel());
    }

    public DatabaseGrpc.DatabaseBlockingStub databaseBlockingStub() {
        return DatabaseGrpc.newBlockingStub(managedChannel());
    }

    public DrawingGrpc.DrawingBlockingStub drawingBlockingStub() {
        return DrawingGrpc.newBlockingStub(managedChannel());
    }

    public OptionFuturesGrpc.OptionFuturesBlockingStub optionFuturesBlockingStub(){
        return OptionFuturesGrpc.newBlockingStub(managedChannel());
    }

    @Bean public StyleFactorGrpc.StyleFactorBlockingStub styleFactorBlockingStub(){
        return StyleFactorGrpc.newBlockingStub(managedChannel());
    }

    @Bean public TailRiskGrpc.TailRiskBlockingStub tailRiskBlockingStub(){
        return TailRiskGrpc.newBlockingStub(managedChannel());
    }

    public boolean stockLeastPosition(String stockCode, int userPosition, int setting) {
        RegularAdjustmentProto.StockLeastPositionInput.Builder builder = RegularAdjustmentProto.StockLeastPositionInput.newBuilder();
        builder.setStockCode(stockCode).setUserPosition(userPosition).setSetting(setting);
        RegularAdjustmentProto.StockLeastPositionInput stockLeastPositionInput = builder.build();
        RegularAdjustmentProto.StockLeastPositionOutput stockLeastPositionOutput = regularAdjustmentBlockingStub().stockLeastPosition(stockLeastPositionInput);
        return stockLeastPositionOutput.getValue();
    }

    public static void main(String[] args) {
        RpcTest rpcTest = new RpcTest();
        boolean res = rpcTest.stockLeastPosition("chph00000", 12, 12);
        System.err.println(res);
    }
}
