package com.pao.examdemo.domain;

import com.pao.examdemo.domain.enumeration.Grade;
import com.pao.examdemo.domain.enumeration.Subject;

import javax.persistence.*;
import java.util.List;

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
    private int paperDifficulty;

    /*
    试卷年份
     */
    @Column(nullable = false)
    private String date;

    /*
    学科
     */
    @Column(nullable = false)
    private Subject paperSubject;

    /*
        试卷里包含的题目
         */
    @OneToMany(cascade = CascadeType.ALL)
    private List<Question> questions;

    /*
    试卷所属学校
     */
    @ManyToOne(cascade = CascadeType.ALL)
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

    public int getPaperDifficulty() {
        return paperDifficulty;
    }

    public void setPaperDifficulty(int paperDifficulty) {
        this.paperDifficulty = paperDifficulty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Subject getPaperSubject() {
        return paperSubject;
    }

    public void setPaperSubject(Subject paperSubject) {
        this.paperSubject = paperSubject;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public School getPaperSchool() {
        return paperSchool;
    }

    public void setPaperSchool(School paperSchool) {
        this.paperSchool = paperSchool;
    }
}
