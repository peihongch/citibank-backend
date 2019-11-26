package com.example.ffbackend.entity;

import com.example.ffbackend.vo.NewsVo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "news")
public class News {
    @Id
    int id;

    String stockId;
    String title;
    String url;
    String date;
    public NewsVo createVo(){
        return new NewsVo(title,url,date);
    }
}
