package com.example.ffbackend.repo;

import com.example.ffbackend.entity.RegularAdjustmentCycleTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RegularAdjustmentCycleTimeRepo extends JpaRepository<RegularAdjustmentCycleTime, Integer> {
    RegularAdjustmentCycleTime findByUserId (Integer userId);
}