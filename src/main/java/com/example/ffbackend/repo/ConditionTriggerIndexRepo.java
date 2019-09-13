package com.example.ffbackend.repo;

import java.util.List;

import com.example.ffbackend.entity.ConditionTriggerIndex;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionTriggerIndexRepo extends JpaRepository<ConditionTriggerIndex, Integer> {
    List<ConditionTriggerIndex> findByUserId (Integer userId);
    void deleteByUserId (Integer userId);
}