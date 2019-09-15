package com.example.ffbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.ffbackend.bl.TransactionService;
import com.example.ffbackend.vo.ResponseBean;
import com.example.ffbackend.vo.TransactionVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
public class TransactionController {
    @Autowired
    TransactionService bl;

    /**
     * 获取累计历史记录
     */
    @GetMapping(value = "/{user-id}/transaction")
    public ResponseBean<List<TransactionVo>> getTransaction(@PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, bl.getTransactions(userId));
    }
}