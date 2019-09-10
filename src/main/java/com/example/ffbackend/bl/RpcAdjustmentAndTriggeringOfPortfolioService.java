package com.example.ffbackend.bl;

public interface RpcAdjustmentAndTriggeringOfPortfolioService {
    /**
     * - 语法：
     *   - portfolio_var(portfolio: dict, setting: float) -> bool
     * - 输入：
     *   - price: 投资组合的历史价值
     *   - setting: 用户设置的var下界
     * - 说明：
     *   - 计算投资组合的VaR，返回是否调整。
     */
    boolean portFolioVar(String price, float setting);

    /**
     * - 语法：
     *   - stock_volatility(portfolio: dict, setting: float) -> bool
     * - 输入：
     *   - price: 投资组合的历史价值
     *   - setting: 用户设置的波动率上界
     * - 说明：
     *   - 返回是否调整。
     */
    boolean stockVolatility(String price, float setting);

    /**
     * - 语法：
     *   - stock_volatility(portfolio: dict, setting: float) -> bool
     * - 输入：
     *   - price: 投资组合的历史价值
     *   - setting: 用户设置的差值上界
     * - 说明：
     *   - 返回是否调整。
     */
    boolean stockDiff(String price, float setting);
}
