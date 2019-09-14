package com.example.ffbackend.bl;

import com.example.ffbackend.vo.ChargeVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargeService {
    @Autowired
    UserService userService;

    @Autowired
    RpcCitibankApiService citibankApiService;

    public void createCharge (Integer userId, ChargeVo vo) {
        // TODO: citibankApiService
        userService.updateUserFund(userId, vo.getMoney());
    }
}