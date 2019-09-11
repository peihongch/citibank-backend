package com.example.ffbackend.da;

import com.example.ffbackend.entity.Portfolio;
import com.example.ffbackend.entity.Post;
import com.example.ffbackend.repo.PortfolioRepo;
import com.example.ffbackend.repo.PostRepo;
import com.example.ffbackend.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostDaServiceImpl implements PostDaService {
    @Autowired
    PostRepo repo;

    @Override
    public List<PostVo> getPostsByUserId(Integer userId) {
        List<Post> l = repo.findPostByUserId(userId);
        List<PostVo> ll = new ArrayList<>();
        for(Post p: l){
            ll.add(new PostVo(p));
        }
        return ll;
    }
}