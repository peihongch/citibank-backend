package com.example.ffbackend.vo;

import com.example.ffbackend.entity.Post;

public class PostVo {
    Integer id;
    String name;
    int viewTimes;

    public PostVo(Post post){
        this.id = post.getId();
        this.name = post.getTitle();
        this.viewTimes = post.getViewTimes();
    }
}
