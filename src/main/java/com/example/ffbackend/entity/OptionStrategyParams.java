package com.example.ffbackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.ffbackend.vo.OptionStrategyParamsVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class OptionStrategyParams {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Integer userId;

    Integer schemeChoose;
    String optionChooseName;
    String optionOneChooseName;
    String optionTwoChooseName;
    Double hedgeRatio;
    Integer buyNum;

    public OptionStrategyParamsVo createVo() {
        return new OptionStrategyParamsVo(schemeChoose, optionChooseName, optionOneChooseName, optionTwoChooseName,
                hedgeRatio, buyNum);
    }
}