package com.example.ffbackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String summary;
    Boolean isEssential;
    String[] labels;
    Date createTime;
    Integer viewTimes;
    Integer comments;
    Integer likes;

    @JoinColumn(name = "user_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    User user;
}
