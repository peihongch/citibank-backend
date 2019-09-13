package com.example.ffbackend.vo;

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
}