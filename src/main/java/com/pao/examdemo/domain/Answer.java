package com.pao.examdemo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long answerId;

    /*
    答案文本
     */
    @Column(nullable = false)
    private String answerText;

    /*
    答案中可能包含一些图片
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<AnswerImage> answerImages;

    /*
    答案解释
     */
    @Column(nullable = false)
    private String answerExplain;

    /*
    答案解释中可能也包含一些图片
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<ExplainImage> answerExplainImages;

    //双向一对一
    @OneToOne(cascade = CascadeType.ALL ,mappedBy = "questionAnswer")
    private Question answerQuestion;

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public List<AnswerImage> getAnswerImages() {
        return answerImages;
    }

    public void setAnswerImages(List<AnswerImage> answerImages) {
        this.answerImages = answerImages;
    }

    public String getAnswerExplain() {
        return answerExplain;
    }

    public void setAnswerExplain(String answerExplain) {
        this.answerExplain = answerExplain;
    }

    public List<ExplainImage> getAnswerExplainImages() {
        return answerExplainImages;
    }

    public void setAnswerExplainImages(List<ExplainImage> answerExplainImages) {
        this.answerExplainImages = answerExplainImages;
    }

    public Question getAnswerQuestion() {
        return answerQuestion;
    }

    public void setAnswerQuestion(Question answerQuestion) {
        this.answerQuestion = answerQuestion;
    }
}
