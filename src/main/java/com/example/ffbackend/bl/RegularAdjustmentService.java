package com.example.ffbackend.bl;

import java.util.List;

import com.example.ffbackend.da.RegularAdjustmentDaService;
import com.example.ffbackend.vo.RegularAdjustmentIndexVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegularAdjustmentService {
    @Autowired
    RegularAdjustmentDaService da;

    public List<RegularAdjustmentIndexVo> getIndexsByUserId (Integer userId) {
        return null;
    }

    public void updateIndex (Integer userId, List<RegularAdjustmentIndexVo> vo) {
    }
}