package com.example.ffbackend.da;

import com.example.ffbackend.entity.Portfolio;
import com.example.ffbackend.vo.PostVo;

import java.util.List;

public interface PostDaService {
    List<PostVo> getPostsByUserId(Integer userId);
}