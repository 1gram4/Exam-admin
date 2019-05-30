package com.pao.examdemo.domain;

import com.pao.examdemo.domain.enumeration.Grade;
import com.pao.examdemo.domain.enumeration.QuestionType;
import com.pao.examdemo.domain.enumeration.Subject;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Question {

    //主建
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;

    //问题类型
    @Column(nullable = false)
    private QuestionType questionType;

    //选择题对应选项
    private String choiceA;


    private String choiceB;


    private String choiceC;


    private String choiceD;

    //题目分值
    @Column(nullable = false)
    private int score;

    //难度系数
    @Column(nullable = false)
    private int difficulty;

    //学科
    @Column(nullable = false)
    private Subject questionSubject;

    //年级
    @Column(nullable = false)
    private Grade grade;

    //题干文本描述
    @Column(nullable = false)
    private String questionText;

    //知识点，单向多对多
    @ManyToMany(cascade = CascadeType.ALL)
    private List<KnowledgePoint> knowledgePoints;

    //题目相关图片
    @OneToMany(cascade = CascadeType.ALL)
    private List<QuestionImage> images;

    //答案，双向一对一
    @OneToOne(cascade = CascadeType.ALL)
    private Answer questionAnswer;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Subject getQuestionSubject() {
        return questionSubject;
    }

    public void setQuestionSubject(Subject questionSubject) {
        this.questionSubject = questionSubject;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<KnowledgePoint> getKnowledgePoints() {
        return knowledgePoints;
    }

    public void setKnowledgePoints(List<KnowledgePoint> knowledgePoints) {
        this.knowledgePoints = knowledgePoints;
    }

    public List<QuestionImage> getImages() {
        return images;
    }

    public void setImages(List<QuestionImage> images) {
        this.images = images;
    }

    public Answer getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(Answer questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}
