package com.example.ffbackend.controller;

import com.example.ffbackend.bl.RpcRegularAdjustmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rpc")
public class RpcTestController {
    @Autowired
    private RpcRegularAdjustmentService rpcRegularAdjustmentService;

    @GetMapping("/stock-least-position")
    public boolean stockLeastPosition() {
        return rpcRegularAdjustmentService.stockLeastPosition("chph00000", 12, 34);
    }
}
