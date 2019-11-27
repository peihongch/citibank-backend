package com.example.ffbackend.rpc;

import com.example.ffbackend.bl.RpcOptionFuturesService;
import com.example.ffbackend.rpc.proto.OptionFuturesGrpc;
import com.example.ffbackend.rpc.proto.OptionFuturesProto.*;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RpcOptionFuturesServiceImpl implements RpcOptionFuturesService {
    @Autowired
    private OptionFuturesGrpc.OptionFuturesBlockingStub optionFuturesBlockingStub;

    //=========================================================
    // xhl新增加的4个接口
    //=========================================================

    @Override
    public List<String> GetAllOptions() {
        GetAllOptionsInput getAllOptionsInput = GetAllOptionsInput.newBuilder().build();
        GetAllOptionsOutput optionsOutput = optionFuturesBlockingStub.getAllOptions(getAllOptionsInput);
        return optionsOutput.getValueList();
    }

    @Override
    public List<String> GetAllFutures() {
        GetAllFuturesInput getAllFuturesInput = GetAllFuturesInput.newBuilder().build();
        GetAllFuturesOutput getAllFuturesOutput = optionFuturesBlockingStub.getAllFutures(getAllFuturesInput);
        return getAllFuturesOutput.getValueList();
    }

    @Override
    public String GetFutureInfo(String id) {
        GetFutureInfoInput getFutureInfoInput = GetFutureInfoInput.newBuilder().setId(id).build();
        GetFutureInfoOutput getFutureInfoOutput = optionFuturesBlockingStub.getFutureInfo(getFutureInfoInput);
        return getFutureInfoOutput.getValue();
    }

    @Override
    public String GetOptionInfo(String id) {
        GetOptionInfoInput getOptionInfoInput = GetOptionInfoInput.newBuilder().setId(id).build();
        GetOptionInfoOutput getOptionInfoOutput = optionFuturesBlockingStub.getOptionInfo(getOptionInfoInput);
        return getOptionInfoOutput.getValue();
    }

    //=========================================================
    //期权部分函数
    //=========================================================

    @Override
    public List<String> portfolioDelta(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT) {
        PortfolioDeltaInput.Builder builder = PortfolioDeltaInput.newBuilder();
        builder.addAllAssetId(assetId).addAllAssetAmount(assetAmount).setCash(cash).setBeginT(beginT).setEndT(endT);
        PortfolioDeltaOutput output = optionFuturesBlockingStub.portfolioDelta(builder.build());
        return output.getValueList();
    }

    @Override
    public List<String> portfolioGamma(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT) {
        PortfolioGammaInput.Builder builder = PortfolioGammaInput.newBuilder();
        builder.addAllAssetId(assetId).addAllAssetAmount(assetAmount).setCash(cash).setBeginT(beginT).setEndT(endT);
        PortfolioGammaOutput output = optionFuturesBlockingStub.portfolioGamma(builder.build());
        return output.getValueList();
    }

    @Override
    public List<String> portfolioVega(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT) {
        PortfolioVegaInput.Builder builder = PortfolioVegaInput.newBuilder();
        builder.addAllAssetId(assetId).addAllAssetAmount(assetAmount).setCash(cash).setBeginT(beginT).setEndT(endT);
        PortfolioVegaOutput output = optionFuturesBlockingStub.portfolioVega(builder.build());
        return output.getValueList();
    }

    @Override
    public List<String> portfolioTheta(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT) {
        PortfolioThetaInput.Builder builder = PortfolioThetaInput.newBuilder();
        builder.addAllAssetId(assetId).addAllAssetAmount(assetAmount).setCash(cash).setBeginT(beginT).setEndT(endT);
        PortfolioThetaOutput output = optionFuturesBlockingStub.portfolioTheta(builder.build());
        return output.getValueList();
    }

    @Override
    public List<String> portfolioRho(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT) {
        PortfolioRhoInput.Builder builder = PortfolioRhoInput.newBuilder();
        builder.addAllAssetId(assetId).addAllAssetAmount(assetAmount).setCash(cash).setBeginT(beginT).setEndT(endT);
        PortfolioRhoOutput output = optionFuturesBlockingStub.portfolioRho(builder.build());
        return output.getValueList();
    }

    @Override
    public List<String> portfolioVolatility(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT) {
        PortfolioVolatilityInput.Builder builder = PortfolioVolatilityInput.newBuilder();
        builder.addAllAssetId(assetId).addAllAssetAmount(assetAmount).setCash(cash).setBeginT(beginT).setEndT(endT);
        PortfolioVolatilityOutput output = optionFuturesBlockingStub.portfolioVolatility(builder.build());
        return output.getValueList();
    }

    @Override
    public List<String> portfolioEarningRate(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT, int time) {
        PortfolioEarningRateInput.Builder builder = PortfolioEarningRateInput.newBuilder();
        builder.addAllAssetId(assetId).addAllAssetAmount(assetAmount).setCash(cash).setBeginT(beginT).setEndT(endT);
        PortfolioEarningRateOutput output = optionFuturesBlockingStub.portfolioEarningRate(builder.build());
        return output.getValueList();
    }

    @Override
    public void retrainDeltaModel(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String options) {
        RetrainDeltaModelInput.Builder builder = RetrainDeltaModelInput.newBuilder();
        builder.setProtfolioId(protfolioId).addAllAssetId(assetId).addAllAssetAmount(assetAmount).setCash(cash).setOptions(options);
        optionFuturesBlockingStub.retrainDeltaModel(builder.build());
    }

    @Override
    public void retrainGammaModel(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String options1, String options2) {
        RetrainGammaModelInput.Builder builder = RetrainGammaModelInput.newBuilder();
        builder.setProtfolioId(protfolioId).addAllAssetId(assetId).addAllAssetAmount(assetAmount).setCash(cash).setOptions1(options1).setOptions2(options2);
        optionFuturesBlockingStub.retrainGammaModel(builder.build());
    }

    @Override
    public List<Float> fitDelta(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String options, String beginT, String endT) {
        FitDeltaInput.Builder builder = FitDeltaInput.newBuilder();
        builder.setProtfolioId(protfolioId)
                .addAllAssetId(assetId)
                .addAllAssetAmount(assetAmount)
                .setCash(cash)
                .setOptions(options)
                .setBeginT(beginT)
                .setEndT(endT);
        FitDeltaInput input = builder.build();
        FitDeltaOutput output = optionFuturesBlockingStub.fitDelta(input);
        return output.getValueList();

    }

    @Override
    public List<Float> fitGamma(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String options1, String options2, String beginT, String endT) {
        var builder = FitGammaInput.newBuilder();
        var input = builder.setProtfolioId(protfolioId)
                .addAllAssetId(assetId)
                .addAllAssetAmount(assetAmount)
                .setCash(cash)
                .setOptions1(options1)
                .setOptions2(options2)
                .setBeginT(beginT)
                .setEndT(endT)
                .build();
        return optionFuturesBlockingStub.fitGamma(input).getValueList();
    }

    @Override
    public int calOptionAmt(float totalValue, String option, float portion) {
        var builder = CalOptionAmtInput.newBuilder();
        var input = builder.setTotalValue(totalValue)
                .setOption(option)
                .setPortion(portion)
                .build();
        return optionFuturesBlockingStub.calOptionAmt(input).getValue();
    }

    @Override
    public List<String> generateRecommendOptionDelta(String protfolioId, List<String> assetId, List<String> assetAmount, float cash) {
        var builder = GenerateRecommendOptionDeltaInput.newBuilder();
        var input = builder.setProtfolioId(protfolioId)
                .addAllAssetId(assetId)
                .addAllAssetAmount(assetAmount)
                .setCash(cash)
                .build();
        return optionFuturesBlockingStub.generateRecommendOptionDelta(input).getValueList();
    }

    @Override
    public List<String> generateRecommendOptionGamma(String protfolioId,List<String> assetId, List<String> assetAmount, float cash) {
        var builder = GenerateRecommendOptionGammaInput.newBuilder();
        var input = builder.setProtfolioId(protfolioId)
                .addAllAssetId(assetId)
                .addAllAssetAmount(assetAmount)
                .setCash(cash)
                .build();
        return optionFuturesBlockingStub.generateRecommendOptionGamma(input).getValueList();
    }

    //=========================================================
    //期货部分函数
    //=========================================================

    @Override
    public float portfolioBeta(List<String> assetId, List<Integer> weights) {
        var builder = PortfolioBetaInput.newBuilder();
        var input = builder.addAllAssetId(assetId).addAllWeight(weights)
                .build();
        return optionFuturesBlockingStub.portfolioBeta(input).getValue();
    }

    @Override
    public void retrainBetaModel(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String futures) {
        var builder = RetrainBetaModelInput.newBuilder();
        var input = builder.addAllAssetId(assetId)
                .addAllAssetAmount(assetAmount)
                .setCash(cash)
                .setFutures(futures)
                .build();
        optionFuturesBlockingStub.retrainBetaModel(input);
    }

    @Override
    public List<Float> fitBeta(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String futures) {
        var builder = FitBetaInput.newBuilder();
        var input = builder.setProtfolioId(protfolioId)
                .addAllAssetId(assetId)
                .addAllAssetAmount(assetAmount)
                .setCash(cash)
                .setFutures(futures)
                .build();
        return optionFuturesBlockingStub.fitBeta(input).getValueList();
    }

    @Override
    public int calFuturesAmt(float totalValue, String futures, float portion) {
        var builder = CalFutureAmtInput.newBuilder();
        var input = builder.setTotalValue(totalValue)
                .setPortion(portion)
                .setFutures(futures)
                .build();
        return optionFuturesBlockingStub.calFutureAmt(input).getValue();
    }

    @Override
    public List<String> generateRecommendFuture(List<String> assetId, List<String> assetAmount, float cash, String beginT) {
        var builder = GenerateRecommendFutureInput.newBuilder();
        var input= builder.addAllAssetId(assetId)
                .addAllAssetAmount(assetAmount)
                .setCash(cash)
                .setBeginT(beginT)
                .build();
        return optionFuturesBlockingStub.generateRecommendFuture(input).getValueList();
    }
}
