package com.example.ffbackend.rpc;

import com.example.ffbackend.bl.RpcDrawingService;
import com.example.ffbackend.rpc.proto.DrawingGrpc;
import com.example.ffbackend.rpc.proto.DrawingProto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RpcDrawingServiceImpl implements RpcDrawingService {
    @Autowired
    private DrawingGrpc.DrawingBlockingStub drawingBlockingStub;

    @Override
    public float predStockReturn(String stockCode, String date, String method) {
        PredStockReturnInput predStockReturnInput = PredStockReturnInput.newBuilder()
                .setStockCode(stockCode).setDate(date).setMethod(method).build();
        PredStockReturnOutput predStockReturnOutput = drawingBlockingStub.predStockReturn(predStockReturnInput);
        return predStockReturnOutput.getPred();
    }

    @Override
    public float predStockVol(String stockCode, String date) {
        PredStockVolInput predStockVolInput = PredStockVolInput.newBuilder()
                .setStockCode(stockCode).setDate(date).build();
        PredStockVolOutput predStockVolOutput = drawingBlockingStub.predStockVol(predStockVolInput);
        return predStockVolOutput.getPred();
    }

    @Override
    public float predPortfolioReturn(List<String> portfolio, List<Integer> shares, String date, String method) {
        PredPortfolioReturnInput predPortfolioReturnInput = PredPortfolioReturnInput.newBuilder()
                .addAllPortfolio(portfolio).addAllShares(shares).setDate(date).setMethod(method).build();
        PredPortfolioReturnOutput predPortfolioReturnOutput = drawingBlockingStub.predPortfolioReturn(predPortfolioReturnInput);
        return predPortfolioReturnOutput.getPred();
    }

    @Override
    public float predPortfolioVar(List<String> portfolio, List<Integer> shares, String date) {
        PredPortfolioVarInput predPortfolioVarInput = PredPortfolioVarInput.newBuilder()
                .addAllPortfolio(portfolio).addAllShares(shares).setDate(date).build();
        PredPortfolioVarOutput predPortfolioVarOutput = drawingBlockingStub.predPortfolioVar(predPortfolioVarInput);
        return predPortfolioVarOutput.getPred();
    }

    @Override
    public String portfolioHistoryReturn(List<String> portfolio, List<Integer> shares, String startDate, String endDate) {
        PortfolioHistoryReturnInput portfolioHistoryReturnInput = PortfolioHistoryReturnInput.newBuilder()
                .addAllPortfolio(portfolio).addAllShares(shares).setStartDate(startDate).setEndDate(endDate).build();
        PortfolioHistoryReturnOutput portfolioHistoryReturnOutput = drawingBlockingStub.portfolioHistoryReturn(portfolioHistoryReturnInput);
        return portfolioHistoryReturnOutput.getValue();
    }

    @Override
    public String portfolioHistoryVol(List<String> portfolio, List<Integer> shares, String startDate, String endDate) {
        PortfolioHistoryVolInput portfolioHistoryVolInput = PortfolioHistoryVolInput.newBuilder()
                .addAllPortfolio(portfolio).addAllShares(shares).setStartDate(startDate).setEndDate(endDate).build();
        PortfolioHistoryVolOutput portfolioHistoryVolOutput = drawingBlockingStub.portfolioHistoryVol(portfolioHistoryVolInput);
        return portfolioHistoryVolOutput.getValue();
    }
}
