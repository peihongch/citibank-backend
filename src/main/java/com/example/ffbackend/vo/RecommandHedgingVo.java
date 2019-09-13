package com.example.ffbackend.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommandHedgingVo {
    String code;
    Double hedgeRate;
    Double volatility;
    Double earnRate;
}