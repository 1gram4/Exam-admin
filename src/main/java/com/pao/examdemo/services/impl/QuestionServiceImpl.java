package com.pao.examdemo.services.impl;

import com.pao.examdemo.domain.Question;
import com.pao.examdemo.domain.enumeration.Grade;
import com.pao.examdemo.domain.enumeration.QuestionType;
import com.pao.examdemo.domain.enumeration.Subject;
import com.pao.examdemo.repository.QuestionRepository;
import com.pao.examdemo.services.QuestionService;
import com.pao.examdemo.utils.QuestionDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question findQuestionByDemand(Subject subject, Grade grade, QuestionType questionType,int minF,int maxF) {
        return questionRepository.findByDemand(subject, grade, questionType,minF,maxF);
    }
}
