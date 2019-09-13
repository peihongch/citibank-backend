package com.example.ffbackend.bl;

import java.util.ArrayList;
import java.util.List;

import com.example.ffbackend.da.ConditionTriggerDaService;
import com.example.ffbackend.entity.ConditionTriggerIndex;
import com.example.ffbackend.vo.ConditionTriggerIndexVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class ConditionTriggerService {
    @Autowired
    ConditionTriggerDaService da;

    public void updateConditionTriggerIndexs(Integer userId, List<ConditionTriggerIndexVo> vo) {
        var pos = new ArrayList<ConditionTriggerIndex>(vo.size());
        for (var indexVo : vo)
            pos.add(indexVo.createPo(userId));
        da.updateConditionTriggerIndexs(userId, pos);
    }

    public List<ConditionTriggerIndexVo> getConditionTiggerIndexs(Integer userId) {
        var pos = da.getConditionTriggerIndexsByUserId(userId);
        var vo = new ArrayList<ConditionTriggerIndexVo>(pos.size());
        for (var po : pos)
            vo.add(po.createVo());
        return new ArrayList<>();
    }
}