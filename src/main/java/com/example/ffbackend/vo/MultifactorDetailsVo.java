package com.example.ffbackend.vo;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class MultifactorDetailsVo {
    @Data
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