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
    public boolean portfolioVar(String portfolio, float setting) {
        PortFolioVarInput portFolioVarInput = PortFolioVarInput.newBuilder()
                .setPortfolio(portfolio).setSetting(setting).build();
        PortFolioVarOutput portFolioVarOutput = adjustmentAndTriggeringOfPortfolioBlockingStub.portFolioVar(portFolioVarInput);
        return portFolioVarOutput.getValue();
    }

    @Override
    public boolean portfolioVolatility(String portfolio, float cash, float setting) {
        PortfolioVolatilityInputs portfolioVolatilityInputs = PortfolioVolatilityInputs.newBuilder()
                .setPortfolio(portfolio).setCash(cash).setSetting(setting).build();
        PortfolioVolatilityOutputs portfolioVolatilityOutputs = adjustmentAndTriggeringOfPortfolioBlockingStub.portfolioVolatility(portfolioVolatilityInputs);
        return portfolioVolatilityOutputs.getValue();
    }

    @Override
    public boolean portfolioDiff(String portfolioId, String portfolio, float cash, float alpha, float setting) {
        PortfolioDiffInput portfolioDiffInput = PortfolioDiffInput.newBuilder()
                .setPortfolioId(portfolioId).setPortfolio(portfolio).setCash(cash).setAlpha(alpha).setTop(setting).build();
        PortfolioDiffOutput portfolioDiffOutput = adjustmentAndTriggeringOfPortfolioBlockingStub.portfolioDiff(portfolioDiffInput);
        return portfolioDiffOutput.getValue();
    }
}
