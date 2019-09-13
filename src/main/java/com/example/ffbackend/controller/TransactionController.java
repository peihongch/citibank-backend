package com.example.ffbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.var;

import java.util.ArrayList;
import java.util.List;

import com.example.ffbackend.bl.TransactionService;
import com.example.ffbackend.entity.Transaction;
import com.example.ffbackend.vo.ResponseBean;
import com.example.ffbackend.vo.TradeVo;
import com.example.ffbackend.vo.TransactionVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class TransactionController {
    @Autowired
    TransactionService bl;

    @PostMapping(value = "/{user-id}/transaction")
    public ResponseBean<Object> postTransaction(@PathVariable("user-id") Integer userId, @RequestBody TradeVo vo) {
        bl.createTransaction(userId, vo);
        return new ResponseBean<>(true, (Object) null);
    }

    /**
     * 获取累计历史记录
     */
    @GetMapping(value = "/{user-id}/transaction")
    public ResponseBean<List<TransactionVo>> getTransaction(@PathVariable("user-id") Integer userId) {
        var entities = bl.getTransactions(userId);
        var vos = new ArrayList<TransactionVo>(entities.size());
        for (var entity : entities)
            vos.add(TransactionVo.getVo(entity));
        return new ResponseBean<>(true, vos);
    }
}