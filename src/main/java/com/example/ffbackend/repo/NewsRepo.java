package com.example.ffbackend.repo;

import com.example.ffbackend.entity.News;
import com.example.ffbackend.vo.NewsVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsRepo extends JpaRepository<News, Integer> {

    public List<News> getNewsVoByStockId(String stockCode);


}
