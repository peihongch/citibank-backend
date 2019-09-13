package com.example.ffbackend.vo;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultifactorDetailsVo {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class MultifactorDatasetVo {
        String name;
        String code;
        Map<String, Double> factor;
        Double price;
        Integer share;
        Integer tip;
    }
    Double balance;
    Double threhold;
    List<MultifactorDatasetVo> dataSource;
}