package com.example.ffbackend.controller;

import com.example.ffbackend.bl.ConditionTriggerService;
import com.example.ffbackend.vo.ConditionTriggerIndexVo;
import com.example.ffbackend.vo.ResponseBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ConditionTriggerController {
    @Autowired
    ConditionTriggerService conditionTriggerService;

    @GetMapping(value = "/{user-id}/condition-trigger/indexs")
    public ResponseBean<List<ConditionTriggerIndexVo>> getConditionTriggerIndexs(
            @PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, conditionTriggerService.getConditionTiggerIndexs(userId));
    }

    @PutMapping(value = "/{user-id}/condition-trigger/indexs")
    public ResponseBean<Object> putConditionTriggerIndexs(@PathVariable("user-id") Integer userId,
            @RequestBody List<ConditionTriggerIndexVo> vo) {
        conditionTriggerService.updateConditionTriggerIndexs(userId, vo);
        return new ResponseBean<>(true, (Object) null);
    }
}
