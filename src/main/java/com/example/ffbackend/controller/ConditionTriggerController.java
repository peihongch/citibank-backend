package com.example.ffbackend.controller;

import com.example.ffbackend.vo.ConditionTriggerIndexVo;
import com.example.ffbackend.vo.RegularAdjustmentIndexVo;
import com.example.ffbackend.vo.ResponseBean;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class ConditionTriggerController {

    @GetMapping(value = "/{user-id}/condition-trigger/indexs")
    public ResponseBean<List<ConditionTriggerIndexVo>> getConditionTriggerIndexs(
            @PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, new ArrayList<>());
    }

    @PutMapping(value = "/{user-id}/condition-trigger/indexs")
    public ResponseBean<Object> putConditionTriggerIndexs(@PathVariable("user-id") String userId,
            @RequestBody RegularAdjustmentIndexVo vo) {
        return new ResponseBean<>(true, (Object) null);
    }
}
