package com.example.ffbackend.bl;

import com.example.ffbackend.vo.PostVo;
import com.example.ffbackend.vo.ResponseBean;
import com.example.ffbackend.vo.UserVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PostService {
    List<PostVo> getPostsByUserId(Integer userId);
}