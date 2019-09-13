package com.example.ffbackend.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyPointVo {
    Double delta;
    Double gamma;
    Double theta;
    Double vega;
    Double rho;
    Double volatility7;
    Double volatility15;
    Double volatility30;
    Double volatility120;
    Double vaR;
    Double earnRate1;
    Double earnRate7;
    Double earnRate30;
    Double earnRate120;
    Double holdEarnRate;
}