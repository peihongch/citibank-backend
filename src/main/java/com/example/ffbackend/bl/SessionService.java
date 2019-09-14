package com.example.ffbackend.bl;

import com.example.ffbackend.exception.MyRuntimeException;
import com.example.ffbackend.vo.ResponseEnums;
import com.example.ffbackend.vo.SessionVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.var;

@Service
public class SessionService {
    @Autowired
    UserService userService;

    public SessionVo createSession(String username, String pwd) {
        // TODO: 获取session，库
        var user = userService.getUserByUsername(username);
        if (user == null)
            throw new MyRuntimeException(ResponseEnums.NO_USER_EXIST);
        if (!user.getPassword().equals(pwd))
            throw new MyRuntimeException(ResponseEnums.INVALID_PASSWORD);
        return new SessionVo("sample-session", user.getId());
    }

    public void removeSession(String session) {
        // TODO: 利用Session库用户登出
    }
}