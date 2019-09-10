package com.example.ffbackend.bl;

public interface RpcConditionalTriggerService {
    /**
     * - 语法：
     *   - stock_turnover_rate(top: float, bottom: float) -> bool
     * - 输入：
     *   - stock_code: 股票代码。
     *   - top: 用户设置的换手率上界。
     *   - bottom: 用户设置的换手率下界。
     * - 说明：
     *   - 返回是否调整。
     */
    boolean stockTurnoverRate(String stockCode, float top, float bottom);

    /**
     * - 语法：
     *   - stock_macd( top: float, bottom: float) -> bool
     * - 输入：
     *   - stock_code: 股票的stock代码。
     *   - top: 用户设置的macd上界。
     *   - bottom: 用户设置的macd下界。
     * - 说明：
     *   - 根据最近26日的收盘价，计算出指数平滑移动平均线（Moving Average Convergence and Divergence，简称MACD）。返回是否调整。
     *   - 需要调用talib库。
     */
    boolean stockMacd(String stockCode, float top, float bottom);

    /**
     * - 语法：
     *   - stock_rsi(rsi_time:int, top:float, bottom:float) -> bool
     * - 输入：
     *   - stock_code: 股票的stock代码。
     *   - rsi_time: 用户设置的rsi时间周期，只能为6、12、24中的一个。
     *   - top: 用户设置的rsi上界。
     *   - bottom: 用户设置的rsi下界。
     * - 说明：
     *   - 根据最近24日的收盘价，计算6日、12日、24日的相对强弱指数RSI。返回是否调整
     *   - 需要调用talib库。
     */
    boolean stockRsi(String stockCode, int rsiTime, float top, float bottom);

    /**
     * - 语法：
     *   - stock_kdj(K: float, D: float: J:float) -> bool
     * - 输入：
     *   - stock_code: 股票的stock代码。
     *   - K: 用户设定的K值上界。
     *   - D: 用户设定的D值上界。
     *   - J: 用户设定的J值上界。
     * - 说明：
     *   - 根据最近9日的收盘价，计算随机指标中的K, D, J值。由于本系统只提供卖出，所以一般是设置随机指标上界。返回是否调整。
     */
    boolean stockKdj(String stockCode, float K,float D,float J);

    /**
     * 与stock_change完全相同，调用之即可。
     * @see RpcRegularAdjustmentService#stockChange(String, int, float, float)
     */
    boolean stockRoc(String stockCode, int time, float top,float bottom);

    /**
     * - 语法：
     *   - stock_sharpe(setting: float) -> bool
     * - 输入：
     *   - stock_code: 股票的stock代码。
     *   - setting: 用户设置的以日收益率为标准的夏普比下界。
     * - 说明：
     *   - 返回是否调整。
     */
    boolean stockSharpe(String stockCode, float setting);
}
