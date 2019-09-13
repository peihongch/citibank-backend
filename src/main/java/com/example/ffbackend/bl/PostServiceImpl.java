package com.example.ffbackend.bl;

import com.example.ffbackend.da.PostDaService;
import com.example.ffbackend.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostDaService postDaService;

    @Override
    public List<PostVo> getPostsByUserId(Integer userId) {
        return postDaService.getPostsByUserId(userId);
    }
}