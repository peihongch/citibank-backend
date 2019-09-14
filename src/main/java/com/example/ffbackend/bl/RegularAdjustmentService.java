package com.example.ffbackend.bl;

import java.util.ArrayList;
import java.util.List;

import com.example.ffbackend.da.RegularAdjustmentDaService;
import com.example.ffbackend.entity.RegularAdjustmentCycleTime;
import com.example.ffbackend.entity.RegularAdjustmentIndex;
import com.example.ffbackend.vo.RegularAdjustmentIndexVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class RegularAdjustmentService {
    @Autowired
    RegularAdjustmentDaService da;

    public List<RegularAdjustmentIndexVo> getIndexsByUserId(Integer userId) {
        var pos = da.getIndexsByUserId(userId);
        var vo = new ArrayList<RegularAdjustmentIndexVo>(pos.size());
        for (var po : pos)
            vo.add(po.createVo());
        return vo;
    }

    public void updateIndexs(Integer userId, List<RegularAdjustmentIndexVo> vo) {
        var pos = new ArrayList<RegularAdjustmentIndex>(vo.size());
        for (var voIndex : vo)
            pos.add(voIndex.createPo(userId));
        da.updateIndexs(userId, pos);
    }

    public Integer getCycleTimeByUserId(Integer userId) {
        var po = da.getCycleTimeByUserId(userId);
        if (po == null)
            return 24;
        return po.getCycleTime();
    }

    public void updateCycleTime(Integer userId, Integer cycleTime) {
        da.updateCycleTime(userId, new RegularAdjustmentCycleTime(null, userId, cycleTime));
    }

    // TODO: 定期调整，所有用户扔内存
}
