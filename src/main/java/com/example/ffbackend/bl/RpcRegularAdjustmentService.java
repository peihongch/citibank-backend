package com.example.ffbackend.bl;

public interface RpcRegularAdjustmentService {
    /**
     * - 语法：
     *   - stock_least_position(user_position: int, setting: int) -> bool
     * - 输入：
     *   - stock_code: 股票代码。
     *   - user_position: 用户当前的持仓。
     *   - setting: 用户设置的最少持仓数指标。
     * - 说明：
     *   - 返回是否停止调整。
     *   - 或许需要访问系统其它地方的数据库（用户指定的最少持仓）。
     */
    boolean stockLeastPosition(String stockCode, int userPosition, int setting);

    /**
     * - 语法：
     *   - stock_volatility(time: int, setting: float) -> bool
     * - 输入：
     * - stock_code: 股票代码。
     * - time: 波动率计算的时间周期，可以是1, 7, 30，代表当日，近一周，近一月。
     * - setting: 用户设置在time下的波动率上界
     * - 说明：
     *   - 返回是否调整。
     */
    boolean stockVolatility(String stockCode, int time, float setting);

    /**
     * - 语法：
     *   - stock_change(time: int, top: float, bottom: float) -> bool
     * - 输入：
     *   - stock_code: 股票代码。
     *   - time: 涨跌幅的时间周期，可以是1, 7, 30，代表当日，近一周，近一月。
     *   - top: 用户设置在time内的最大涨幅。
     *   - bottom: 用户设置在time内的最大跌幅。
     * - 说明：
     *   - 返回是否调整。
     */
    boolean stockChange(String stockCode, int time, float top,float bottom);

    /**
     * - 语法：
     *   - stock_mean_return(time: int, setting: float) -> bool
     * - 输入：
     *   - stock_code: 股票代码
     *   - time: 平均收益率的时间周期，可以是1, 7, 30，代表当日，近一周，近一月。
     *   - setting: 用户设置在time下的收益率下界。
     * - 说明：
     *   - 返回是否调整。
     */
    boolean stockMeanReturn(String stockCode, int time, float setting);


}
