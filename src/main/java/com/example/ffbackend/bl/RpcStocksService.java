package com.example.ffbackend.bl;

import java.util.List;

public interface RpcStocksService {
    List<String> getAllStocks();

    /**
     * 根据股票编号获取股票历史信息
     *
     * @param stockCode
     * @return
     */
    List<List<String>> getStockHistory(String stockCode);
}
