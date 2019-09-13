package com.example.ffbackend.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionVo {
    String code;
    String name;
    Double startPrice;
    Double maxPrice;
    Double minPrice;
    Double endPrice;
    Double upDownPrice;
    Integer holdNum;
    Integer tradeNum;
    Double historyVolatility;
    Double impliedVolatility;
}