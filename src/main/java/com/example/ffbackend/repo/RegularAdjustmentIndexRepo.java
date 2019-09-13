package com.example.ffbackend.repo;

import java.util.List;

import com.example.ffbackend.entity.RegularAdjustmentIndex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RegularAdjustmentIndexRepo extends JpaRepository<RegularAdjustmentIndex, Integer> {
    List<RegularAdjustmentIndex> findByUserId (Integer userId);
    void deleteByUserId (Integer userId);
}