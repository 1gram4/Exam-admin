package com.pao.examdemo.domain;

import com.pao.examdemo.domain.enumeration.Grade;
import com.pao.examdemo.domain.question.Question;

import javax.persistence.*;
import java.util.Collection;

/*
试卷实体类
 */
@Entity
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paperId;

    /*
    试卷名称
     */
    @Column(nullable = false)
    private String paperName;

    /*
    试卷年级
     */
    @Column(nullable = false)
    private Grade grade;

    /*
    试卷难度系数
     */
    @Column(nullable = false)
    private float paperDifficulty;

    /*
    试卷年份
     */
    @Column(nullable = false)
    private String Date;

    /*
    试卷里包含的题目
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Question> questions;

    /*
    试卷所属学校
     */
    @OneToOne(cascade = CascadeType.ALL)
    private School paperSchool;

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public float getPaperDifficulty() {
        return paperDifficulty;
    }

    public void setPaperDifficulty(float paperDifficulty) {
        this.paperDifficulty = paperDifficulty;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    public School getPaperSchool() {
        return paperSchool;
    }

    public void setPaperSchool(School paperSchool) {
        this.paperSchool = paperSchool;
    }
}
