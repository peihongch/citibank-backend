package com.example.ffbackend;

import com.example.ffbackend.rpc.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RpcClient {
    @Value("${rpc.host}")
    private String host;
    @Value("${rpc.port}")
    private int port;

    public RpcClient() {
    }

    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    }

    @Bean
    public RegularAdjustmentGrpc.RegularAdjustmentBlockingStub regularAdjustmentBlockingStub() {
        return RegularAdjustmentGrpc.newBlockingStub(managedChannel());
    }

    @Bean
    public AdjustmentAndTriggeringOfPortfolioGrpc.AdjustmentAndTriggeringOfPortfolioBlockingStub adjustmentAndTriggeringOfPortfolioBlockingStub() {
        return AdjustmentAndTriggeringOfPortfolioGrpc.newBlockingStub(managedChannel());
    }

    @Bean
    public CitibankApiGrpc.CitibankApiBlockingStub citibankApiBlockingStub() {
        return CitibankApiGrpc.newBlockingStub(managedChannel());
    }

    @Bean
    public DatabaseGrpc.DatabaseBlockingStub databaseBlockingStub() {
        return DatabaseGrpc.newBlockingStub(managedChannel());
    }

    @Bean
    public DrawingGrpc.DrawingBlockingStub drawingBlockingStub() {
        return DrawingGrpc.newBlockingStub(managedChannel());
    }

    @Bean public OptionFuturesGrpc.OptionFuturesBlockingStub optionFuturesBlockingStub(){
        return OptionFuturesGrpc.newBlockingStub(managedChannel());
    }

    @Bean public StyleFactorGrpc.StyleFactorBlockingStub styleFactorBlockingStub(){
        return StyleFactorGrpc.newBlockingStub(managedChannel());
    }

    @Bean public TailRiskGrpc.TailRiskBlockingStub tailRiskBlockingStub(){
        return TailRiskGrpc.newBlockingStub(managedChannel());
    }

}
