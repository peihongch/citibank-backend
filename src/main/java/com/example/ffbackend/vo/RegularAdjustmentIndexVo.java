package com.example.ffbackend.vo;

import lombok.Data;
import lombok.AllArgsConstructor;
@Data
@AllArgsConstructor
public class RegularAdjustmentIndexVo {
    String indexCode;
    Double numLow;
    Double numHigh;
    Double num;
}