package com.example.ffbackend.bl;

import java.util.List;

public interface RpcOptionFuturesService {
    //=========================================================
    //期权部分函数
    //=========================================================

    List<String> portfolioDelta(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT);

    List<String> portfolioGamma(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT);

    List<String> portfolioVega(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT);

    List<String> portfolioTheta(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT);

    List<String> portfolioRho(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT);

    List<String> portfolioVolatility(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT);

    List<String> portfolioEarningRate(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT, int time);

    void retrainDeltaModel(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String options);

    void retrainGammaModel(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String options1, String options2);

    List<Float> fitDelta(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String options, String beginT, String endT);

    List<Float> fitGamma(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String options1, String options2, String beginT, String endT);

    int calOptionAmt(float totalValue, String option, float portion);

    List<String> generateRecommendOptionDelta(String protfolioId, List<String> assetId, List<String> assetAmount, float cash);

    List<String> generateRecommendOptionGamma(String protfolioId,List<String> assetId, List<String> assetAmount, float cash);

    //=========================================================
    //期货部分函数
    //=========================================================

    float portfolioBeta(List<String> assetId, List<String> assetAmount, float cash, String beginT, String endT);

    void retrainBetaModel(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String futures);

    List<Float> fitBeta(String protfolioId, List<String> assetId, List<String> assetAmount, float cash, String futures, String beginT, String endT);

    int calFuturesAmt(float totalValue, String futures, float portion);

    List<String> generateRecommendFuture(List<String> assetId, List<String> assetAmount, float cash, String beginT);
}
