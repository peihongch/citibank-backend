package com.example.ffbackend.da;

import java.util.List;

import com.example.ffbackend.entity.ConditionTriggerIndex;
import com.example.ffbackend.repo.ConditionTriggerIndexRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConditionTriggerDaService {
    @Autowired
    ConditionTriggerIndexRepo indexRepo;

    public List<ConditionTriggerIndex> getConditionTriggerIndexsByUserId (Integer userId) {
        return indexRepo.findByUserId(userId);
    }

    public void updateConditionTriggerIndexs (Integer userId, List<ConditionTriggerIndex> indexs) {
        indexRepo.deleteByUserId(userId);
        indexRepo.saveAll(indexs);
    }
}