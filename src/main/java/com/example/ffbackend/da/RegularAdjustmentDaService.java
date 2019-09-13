package com.example.ffbackend.da;

import java.util.List;

import com.example.ffbackend.entity.RegularAdjustmentIndex;
import com.example.ffbackend.repo.RegularAdjustmentIndexRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegularAdjustmentDaService {
    @Autowired
    RegularAdjustmentIndexRepo indexRepo;

    public List<RegularAdjustmentIndex> getIndexsByUserId (Integer userId) {
        return indexRepo.findByUserId(userId);
    }

    public void updateIndexs (Integer userId, List<RegularAdjustmentIndex> pos) {
        indexRepo.deleteByUserId(userId);
        indexRepo.saveAll(pos);
    }
}