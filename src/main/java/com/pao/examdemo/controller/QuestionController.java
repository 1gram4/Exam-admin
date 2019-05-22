package com.pao.examdemo.controller;

import com.pao.examdemo.repository.QuestionRepository;
import com.pao.examdemo.utils.NetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private NetResult netResult;
}
