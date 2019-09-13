package com.example.ffbackend.controller;

import com.example.ffbackend.bl.RegularAdjustmentService;
import com.example.ffbackend.vo.RegularAdjustmentIndexVo;
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
public class RegularAdjustmentController {
    @Autowired
    RegularAdjustmentService service;

    @GetMapping(value = "/{user-id}/regular-adjustment/indexs")
    public ResponseBean<List<RegularAdjustmentIndexVo>> getRegularAdjustmentIndexs(
            @PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, service.getIndexsByUserId(userId));
    }

    @PutMapping(value = "/{user-id}/regular-adjustment/indexs")
    public ResponseBean<Object> putRegularAdjustmentIndexs(@PathVariable("user-id") Integer userId,
            @RequestBody List<RegularAdjustmentIndexVo> vo) {
        service.updateIndexs(userId, vo);
        return new ResponseBean<>(true, (Object) null);
    }

    @GetMapping(value = "/{user-id}/regular-adjustment/cycle-time")
    public ResponseBean<Double> getRegularAdjustmentCycleTime(@PathVariable("user-id") Integer userId) {
        return new ResponseBean<>(true, 10.0);
    }

    @PutMapping(value = "/{user-id}/regular-adjustment/cycle-time")
    public ResponseBean<Object> putRegularAdjustmentCycleTime(@PathVariable("user-id") Integer userId,
            @RequestBody RegularAdjustmentIndexVo vo) {
        return new ResponseBean<>(true, (Object) null);
    }
}
