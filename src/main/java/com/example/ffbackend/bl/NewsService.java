package com.example.ffbackend.bl;

import com.example.ffbackend.entity.News;
import com.example.ffbackend.repo.NewsRepo;
import com.example.ffbackend.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class NewsService {
    @Autowired
    NewsRepo newsRepo;

    public List<NewsVo> getNewsByStockCode(String stockCode) {
        try {
            List<News> news = newsRepo.getNewsVoByStockId(stockCode);
            List<NewsVo> newsVos = news.stream().map(news1 -> news1.createVo()).collect(Collectors.toList());
            return newsVos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<NewsVo> getNewsByUserId(Integer userId){
        try {
            List<News> news = newsRepo.findAll();
            List<NewsVo> newsVos = news.stream().map(news1 -> news1.createVo()).collect(Collectors.toList());
            Random r = new Random();
            int i  = r.nextInt(newsVos.size()-15) ;
            return newsVos.subList(i,i+10);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
