package com.example.ffbackend.vo;

import com.example.ffbackend.entity.OptionStrategyParams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionStrategyParamsVo {
    Integer schemeChoose;
    String optionChooseName;
    String optionOneChooseName;
    String optionTwoChooseName;
    Double hedgeRatio;
    Integer buyNum;

    public OptionStrategyParams createPo (Integer userId) {
        return new OptionStrategyParams(userId, schemeChoose, optionChooseName, optionOneChooseName, optionTwoChooseName, hedgeRatio, buyNum);
    }
}