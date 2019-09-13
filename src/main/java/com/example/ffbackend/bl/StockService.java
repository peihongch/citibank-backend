package com.example.ffbackend.bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.ffbackend.vo.StockVo;

import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class StockService {
    public StockVo getStockByCode(String code) {
        return null;
    }

    public String getStockNameByCode(String code) {
        List<String> names = new ArrayList<String>() {
            private static final long serialVersionUID = 5396651156597209178L;
            {
                add("花旗银行");
                add("南大食堂");
                add("蟹老板蟹肉煲");
            }
        };
        var rand = new Random();
        return names.get(rand.nextInt(names.size()));
    }

    public Double getStockPriceByCode(String code) {
        Random rand = new Random();
        return (rand.nextInt(60) + 600) / 100.0;
    }
}
