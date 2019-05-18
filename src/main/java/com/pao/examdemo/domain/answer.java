package com.pao.examdemo.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class answer {
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
    private Collection<Image> answerImages;

    /*
    答案解释
     */
    @Column(nullable = false)
    private String answerExplain;

    /*
    答案解释中可能也包含一些图片
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Image> answerExplainImages;

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

    public Collection<Image> getAnswerImages() {
        return answerImages;
    }

    public void setAnswerImages(Collection<Image> answerImages) {
        this.answerImages = answerImages;
    }

    public String getAnswerExplain() {
        return answerExplain;
    }

    public void setAnswerExplain(String answerExplain) {
        this.answerExplain = answerExplain;
    }

    public Collection<Image> getAnswerExplainImages() {
        return answerExplainImages;
    }

    public void setAnswerExplainImages(Collection<Image> answerExplainImages) {
        this.answerExplainImages = answerExplainImages;
    }
}
