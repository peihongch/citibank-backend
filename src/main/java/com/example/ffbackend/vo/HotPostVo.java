package com.example.ffbackend.vo;

import java.sql.Date;

public class HotPostVo {
    int id;
    String title;
    String summary;
    String author;
    String authorAvatar;
    boolean isEssential;
    String []labels;
    Date createTime;
    int viewTimes;
    int comments;
    int like;
}
