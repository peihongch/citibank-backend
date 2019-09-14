package com.example.ffbackend.rpc;

import com.example.ffbackend.bl.RpcOptionFuturesService;
import com.example.ffbackend.rpc.proto.OptionFuturesGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RpcOptionFuturesServiceImpl implements RpcOptionFuturesService {
    @Autowired
    private OptionFuturesGrpc.OptionFuturesBlockingStub optionFuturesBlockingStub;

    //=========================================================
    //期权部分函数
    //=========================================================

    @Override
    public String portfolioDelta(String assetId, String assetAmount, float cash, String beginT, String endT) {
        return null;
    }

    @Override
    public String portfolioGamma(String assetId, String assetAmount, float cash, String beginT, String endT) {
        return null;
    }

    @Override
    public String portfolioVega(String assetId, String assetAmount, float cash, String beginT, String endT) {
        return null;
    }

    @Override
    public String portfolioTheta(String assetId, String assetAmount, float cash, String beginT, String endT) {
        return null;
    }

    @Override
    public String portfolioRho(String assetId, String assetAmount, float cash, String beginT, String endT) {
        return null;
    }

    @Override
    public String portfolioVolatility(String assetId, String assetAmount, float cash, String beginT, String endT) {
        return null;
    }

    @Override
    public String portfolioEarningRate(String assetId, String assetAmount, float cash, String beginT, String endT, int time) {
        return null;
    }

    @Override
    public void retrainDeltaModel(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String options) {

    }

    @Override
    public void retrainGammaModel(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String options1, String options2) {

    }

    @Override
    public List<Float> fitDelta(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String options, String beginT, String endT) {
        return null;
    }

    @Override
    public List<Float> fitGamma(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String options1, String options2, String beginT, String endT) {
        return null;
    }

    @Override
    public int calOptionAmt(float totalValue, String option, float portion) {
        return 0;
    }

    @Override
    public List<String> generateRecommendOptionDelta(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String beginT) {
        return null;
    }

    @Override
    public List<String> generateRecommendOption(List<String> assetId, List<String> assetAmount, float cash, String beginT) {
        return null;
    }

    //=========================================================
    //期货部分函数
    //=========================================================

    @Override
    public float portfolioBeta(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT) {
        return 0;
    }

    @Override
    public void petrainBetaModel(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String futures) {

    }

    @Override
    public List<Float> fitBeta(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String futures, String beginT, String endT) {
        return null;
    }

    @Override
    public int calFuturesAmt(float totalValue, String futures, float portion) {
        return 0;
    }

    @Override
    public List<String> generateRecommendFuture(List<String> assetId, List<String> assetAmount, float cash, String beginT) {
        return null;
    }
}
