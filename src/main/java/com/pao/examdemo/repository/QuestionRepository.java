package com.pao.examdemo.repository;

import com.pao.examdemo.domain.Question;
import com.pao.examdemo.domain.enumeration.Grade;
import com.pao.examdemo.domain.enumeration.QuestionType;
import com.pao.examdemo.domain.enumeration.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    Question findByQuestionText(String questionText);
    Question findByQuestionTextLike(String QuestionText);
    @Query("select q from Question q  where q.questionSubject=?1 " +
            "and q.grade=?2 and q.questionType=?3 and q.difficulty between ?4 and ?5  ")
    Question findByDemand(Subject subject, Grade grade, QuestionType questionType,int minF,int maxF);
}
