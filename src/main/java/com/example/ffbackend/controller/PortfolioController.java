package com.example.ffbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ffbackend.vo.PortfolioVo;
import com.example.ffbackend.vo.ResponseBean;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    @PostMapping
    public ResponseBean<Object> createPortfolio(@RequestBody PortfolioVo vo) {
        return new ResponseBean<>(true, null);
    }

    @GetMapping(value = "/{id}")
    public ResponseBean<PortfolioVo> getPortfolio(@PathVariable("id") Integer id) {
        return new ResponseBean<>(true, null);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseBean<Object> deletePortfolio(@PathVariable("id") Integer id) {
        return new ResponseBean<>(true, null);
    }

    @PutMapping(value="/{id}")
    public ResponseBean<Object> updatePortfolio(@PathVariable String id, @RequestBody PortfolioVo vo) {
        return new ResponseBean<>(true, null);
    }
}