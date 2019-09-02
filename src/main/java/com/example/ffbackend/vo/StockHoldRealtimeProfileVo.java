package com.example.ffbackend.vo;

import lombok.Data;

@Data
public class StockHoldRealtimeProfileVo {
    String id;
    Double price;
    Double position;
    Double openPositionPrice;
    Double dailyProfitOrLoss;
}