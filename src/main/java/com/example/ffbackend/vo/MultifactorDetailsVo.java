package com.example.ffbackend.vo;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class MultifactorDetailsVo {
    public class MultifactorDataset {
        String name;
        String code;
        Map<String, Double> factor;
        Double price;
        Integer share;
        Integer tip;
    }
    Double balance;
    Double threhold;
    List<MultifactorDataset> dataSource;
}