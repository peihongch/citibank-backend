package com.example.ffbackend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.ffbackend.vo.QuestionnaireVo;
import com.example.ffbackend.vo.ResponseBean;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    @PostMapping
    public ResponseBean<Object> SubmitQuestionnaire(@RequestBody QuestionnaireVo vo) {
        return new ResponseBean<>(true, null);
    }

    @PutMapping
    public ResponseBean<Object> UpdateQuestoinnaire(@RequestBody QuestionnaireVo vo) {
        return new ResponseBean<>(true, null);
    }

    @GetMapping(value = "/{id}")
    public ResponseBean<QuestionnaireVo> GetQuestionnaire(@PathVariable Long param) {
        return new ResponseBean<>(true, null);
    }
}
