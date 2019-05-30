package com.pao.examdemo.services;

import com.pao.examdemo.domain.Question;
import com.pao.examdemo.domain.enumeration.Grade;
import com.pao.examdemo.domain.enumeration.QuestionType;
import com.pao.examdemo.domain.enumeration.Subject;
import com.pao.examdemo.utils.QuestionDemand;

public interface QuestionService {
    Question findQuestionByDemand(Subject subject, Grade grade, QuestionType questionType, int minF, int maxF);
}
