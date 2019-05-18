package com.pao.examdemo.domain.question;

import com.pao.examdemo.domain.Grade;
import com.pao.examdemo.domain.Image;
import com.pao.examdemo.domain.KnowledgePoint;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Question {

    //主建
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;

    /*
    枚举题目类型:选择，判断，填空，大题目
     */
    public enum QuestionType{
        CHOICE,T_OR_F,FILL,HUGE
    }
    @Column(nullable = false)
    private QuestionType questionType;

    //题目分值
    @Column(nullable = false)
    private int score;

    //难度系数
    @Column(nullable = false)
    private float difficulty;

    //年级
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Grade grade;

    //题干文本描述
    @Column(nullable = false)
    private String questionText;

    //知识点
    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<KnowledgePoint> KnowledgePoints;

    //题目相关图片
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Image> images;

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public float getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(float difficulty) {
        this.difficulty = difficulty;
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

    public Collection<KnowledgePoint> getKnowledgePoints() {
        return KnowledgePoints;
    }

    public void setKnowledgePoints(Collection<KnowledgePoint> knowledgePoints) {
        KnowledgePoints = knowledgePoints;
    }

    public Collection<Image> getImages() {
        return images;
    }

    public void setImages(Collection<Image> images) {
        this.images = images;
    }
}
