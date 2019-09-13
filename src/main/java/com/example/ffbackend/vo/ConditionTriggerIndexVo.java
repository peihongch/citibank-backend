package com.example.ffbackend.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.ffbackend.entity.ConditionTriggerIndex;

import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionTriggerIndexVo {
    String indexCode;
    Double num1;
    Double num2;
    Double num3;

    public ConditionTriggerIndex createPo(Integer userId) {
        return new ConditionTriggerIndex(null, userId, indexCode, num1, num2, num3);
    }
}