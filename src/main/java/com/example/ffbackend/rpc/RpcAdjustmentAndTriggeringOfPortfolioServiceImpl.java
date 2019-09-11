package com.example.ffbackend.rpc;

import com.example.ffbackend.bl.RpcAdjustmentAndTriggeringOfPortfolioService;
import com.example.ffbackend.rpc.proto.AdjustmentAndTriggeringOfPortfolioGrpc;
import com.example.ffbackend.rpc.proto.AdjustmentAndTriggeringOfPortfolioProto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RpcAdjustmentAndTriggeringOfPortfolioServiceImpl implements RpcAdjustmentAndTriggeringOfPortfolioService {
    @Autowired
    private AdjustmentAndTriggeringOfPortfolioGrpc.AdjustmentAndTriggeringOfPortfolioBlockingStub
            adjustmentAndTriggeringOfPortfolioBlockingStub;

    @Override
    public boolean portFolioVar(String price, float setting) {
        PortFolioInput portFolioInput = PortFolioInput.newBuilder()
                .setPrice(price).setSetting(setting).build();
        PortFolioOutput portFolioOutput = adjustmentAndTriggeringOfPortfolioBlockingStub.portFolioVar(portFolioInput);
        return portFolioOutput.getValue();
    }

    @Override
    public boolean stockVolatility(String price, float setting) {
        PortFolioInput portFolioInput = PortFolioInput.newBuilder()
                .setPrice(price).setSetting(setting).build();
        PortFolioOutput portFolioOutput = adjustmentAndTriggeringOfPortfolioBlockingStub.portfolioVolatility(portFolioInput);
        return portFolioOutput.getValue();
    }

    @Override
    public boolean stockDiff(String price, float setting) {
        PortFolioInput portFolioInput = PortFolioInput.newBuilder()
                .setPrice(price).setSetting(setting).build();
        PortFolioOutput portFolioOutput = adjustmentAndTriggeringOfPortfolioBlockingStub.portfolioDiff(portFolioInput);
        return portFolioOutput.getValue();
    }
}
