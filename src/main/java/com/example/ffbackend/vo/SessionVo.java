package com.example.ffbackend.vo;

import lombok.Data;

@Data
public class SessionVo {
    String session;
    Integer userId;

    public SessionVo (String session, Integer userId) {
        this.session = session;
        this.userId = userId;
    }
}