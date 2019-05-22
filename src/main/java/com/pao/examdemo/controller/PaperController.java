package com.pao.examdemo.controller;

import com.pao.examdemo.domain.Paper;
import com.pao.examdemo.domain.Question;
import com.pao.examdemo.repository.PaperRepository;
import com.pao.examdemo.utils.NetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
试卷控制层
 */
@RestController
@RequestMapping(value = "/api/v1")
public class PaperController {
    @Autowired
    private PaperRepository paperRepository;
    @Autowired
    private NetResult netResult;

    @RequestMapping(value="/addPaper")
    public Paper addPaper(@RequestBody Paper requestBody){
        System.out.println("123");
        return requestBody;
    }
}
