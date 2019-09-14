package com.example.ffbackend.controller;

import com.example.ffbackend.bl.RpcRegularAdjustmentService;
import com.example.ffbackend.bl.RpcStocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rpc")
public class RpcTestController {
    @Autowired
    private RpcRegularAdjustmentService rpcRegularAdjustmentService;
    @Autowired
    private RpcStocksService rpcStocksService;

    @GetMapping("/stock-least-position")
    public boolean stockLeastPosition() {
        return rpcRegularAdjustmentService.stockLeastPosition("chph00000", 12, 34);
    }

    @GetMapping("/get-all-stocks")
    public List<String> getAllStocks(){
        return rpcStocksService.getAllStocks();
    }
}
