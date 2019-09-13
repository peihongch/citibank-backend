package com.example.ffbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ffbackend.bl.OptionService;
import com.example.ffbackend.vo.KeyPointVo;
import com.example.ffbackend.vo.OptionStrategyParamsVo;
import com.example.ffbackend.vo.OptionVo;
import com.example.ffbackend.vo.RecommandHedgingVo;
import com.example.ffbackend.vo.ResponseBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class OptionController {
    @Autowired
    OptionService service;

    @GetMapping(value = "/{user-id}/option")
    public ResponseBean<OptionVo> getOption(@PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, new OptionVo());
    }

    @GetMapping(value = "/{user-id}/option/recommand-hedging")
    public ResponseBean<RecommandHedgingVo> getRecommandHedging(@PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, new RecommandHedgingVo());
    }

    @GetMapping(value = "/{user-id}/option/strategy-params")
    public ResponseBean<OptionStrategyParamsVo> getStrategyParams(@PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, service.getOptionStrategyParams(userId));
    }

    @PutMapping(value = "/{user-id}/option/strategy-params")
    public ResponseBean<Object> putStrategyParams(@PathVariable("user-id") Integer userId, @RequestBody OptionStrategyParamsVo vo) {
        service.updateOptionStrategyParams(userId, vo);
        return new ResponseBean<>(true, (Object) null);
    }

    @GetMapping(value = "/{user-id}/option/key-point")
    public ResponseBean<KeyPointVo> getKeyPoint(@RequestParam(name = "hedgeStrategyId") Integer hedgeStrategyId,
            @RequestParam(name = "optionCode") String optionCode, @RequestParam(name = "hedgeRate") Double hedgeRate) {
        return new ResponseBean<>(true, new KeyPointVo());
    }

}