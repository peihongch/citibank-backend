package com.example.ffbackend.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.ffbackend.entity.RegularAdjustmentIndex;

import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegularAdjustmentIndexVo {
    String indexCode;
    Double num1;
    Double num2;
    Double num3;

    public RegularAdjustmentIndex createPo (Integer userId) {
        return new RegularAdjustmentIndex(null, userId, indexCode, num1, num2, num3);
    }
}