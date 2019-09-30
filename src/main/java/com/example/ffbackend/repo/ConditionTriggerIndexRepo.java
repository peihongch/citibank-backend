package com.example.ffbackend.repo;

import java.util.List;

import com.example.ffbackend.entity.ConditionTriggerIndex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface ConditionTriggerIndexRepo extends JpaRepository<ConditionTriggerIndex, Integer> {
    List<ConditionTriggerIndex> findByUserId (Integer userId);

    @Modifying
    @Transactional
    void deleteByUserId (Integer userId);
}