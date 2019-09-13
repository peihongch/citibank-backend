package com.example.ffbackend.bl;

import com.example.ffbackend.vo.PostVo;

import java.util.List;

public interface PostService {
    List<PostVo> getPostsByUserId(Integer userId);
}