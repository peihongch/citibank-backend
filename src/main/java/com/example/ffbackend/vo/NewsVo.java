package com.example.ffbackend.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsVo {
    String title;
    String links;
    Date date;
}