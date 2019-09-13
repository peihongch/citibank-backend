package com.example.ffbackend.stubs;

import com.example.ffbackend.vo.RegularAdjustmentIndexVo;

import java.util.ArrayList;

public class RegularAdjustmentIndex {
    public static ArrayList<RegularAdjustmentIndexVo> UserIndex = new ArrayList<RegularAdjustmentIndexVo>(){{
        add(new RegularAdjustmentIndexVo("1",0.0,10.0,0.0));
        add(new RegularAdjustmentIndexVo("2",1.0,10.0,0.0));
        add(new RegularAdjustmentIndexVo("3",5.0,100.0,0.0));
    }};
}