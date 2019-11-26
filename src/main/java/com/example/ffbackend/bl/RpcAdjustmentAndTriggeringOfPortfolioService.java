package com.example.ffbackend.bl;

public interface RpcAdjustmentAndTriggeringOfPortfolioService {
    /**
     * 语法：
     * portfolio_var(portfolio: str, setting: float) -> bool
     * 输入：
     * portfolio: 投资组合的json字符串
     * setting: 用户设置的var上界
     * 说明：
     * 计算投资组合的VaR，返回是否调整。
     */
    boolean portfolioVar(String portfolio, float setting);

    /**
     * 语法：
     * portfolio_volatility(portfolio: str, cash: float, setting: float) -> bool
     * 输入：
     * portfolio: 投资组合的json字符串
     * cash: 用户持有的现金
     * setting: 用户设置的波动率上界
     * 说明：
     * 返回是否调整
     */
    boolean portfolioVolatility(String portfolio, float cash, float setting);

    /**
     * 语法：
     * portfolio_diff(portfolio_id: str, portfolio: str, cash: float, alpha:float, setting: float) -> bool
     * 输入：
     * portfolio_id: 投资组合的标记号码，用于保存模型
     * portfolio: 投资组合的json字符串
     * cash: 用户持有的现金
     * alpha: 用户设置的套保比例，默认为1
     * top: 用户设置的差值上界
     * 说明：
     * 返回是否调整。
     */
    boolean portfolioDiff(String portfolioId, String portfolio, float cash, float alpha, float setting);
}
