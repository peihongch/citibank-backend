package com.example.ffbackend.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ffbackend.da.RegularAdjustmentDaService;
import com.example.ffbackend.entity.RegularAdjustmentCycleTime;
import com.example.ffbackend.entity.RegularAdjustmentIndex;
import com.example.ffbackend.vo.RegularAdjustmentIndexVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class RegularAdjustmentService {
    @Autowired
    RegularAdjustmentDaService da;

    @Autowired
    RpcRegularAdjustmentService rpcRegularAdjustment;

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

    @Scheduled(fixedRate = 11000)
    public void scheduleTrade() {
        var userIndexs = da.getAllIndexs();
        var userCycleTimes = da.getAllCycleTime();
        // NODO: 这就是一坨屎但是不打算改
        Map<Integer, List<RegularAdjustmentIndex>> indexMap = new HashMap<>();
        Map<Integer, Integer> cycleTimeMap = new HashMap<>();
        for (var index : userIndexs) {
            var indexList = indexMap.get(index.getUserId());
            if (indexList == null) {
                indexList = new ArrayList<>();
                indexMap.put(index.getUserId(), indexList);
            }
            indexList.add(index);
        }
        for (var cycleTime : userCycleTimes)
            cycleTimeMap.put(cycleTime.getUserId(), cycleTime.getCycleTime());
        // TODO: 调用交易模块
    }
}
