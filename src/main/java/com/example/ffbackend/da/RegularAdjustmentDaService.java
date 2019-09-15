package com.example.ffbackend.da;

import java.util.List;

import com.example.ffbackend.entity.RegularAdjustmentCycleTime;
import com.example.ffbackend.entity.RegularAdjustmentIndex;
import com.example.ffbackend.repo.RegularAdjustmentCycleTimeRepo;
import com.example.ffbackend.repo.RegularAdjustmentIndexRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class RegularAdjustmentDaService {
    @Autowired
    RegularAdjustmentIndexRepo indexRepo;

    @Autowired
    RegularAdjustmentCycleTimeRepo cycleTimeRepo;

    public List<RegularAdjustmentIndex> getAllIndexs() {
        return indexRepo.findAll();
    }

    public List<RegularAdjustmentIndex> getIndexsByUserId(Integer userId) {
        return indexRepo.findByUserId(userId);
    }

    public void updateIndexs(Integer userId, List<RegularAdjustmentIndex> pos) {
        indexRepo.deleteByUserId(userId);
        indexRepo.saveAll(pos);
    }

    public List<RegularAdjustmentCycleTime> getAllCycleTime() {
        return cycleTimeRepo.findAll();
    }

    public RegularAdjustmentCycleTime getCycleTimeByUserId(Integer userId) {
        return cycleTimeRepo.findByUserId(userId);
    }

    public void updateCycleTime(Integer userId, RegularAdjustmentCycleTime po) {
        var oriPo = cycleTimeRepo.findByUserId(userId);
        if (oriPo != null)
            po.setId(oriPo.getId());
        cycleTimeRepo.save(po);
    }
}