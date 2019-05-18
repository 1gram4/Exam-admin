package com.pao.examdemo.domain.question;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ChoiceQuestion extends Question {
    @Column(nullable = false)
    private String choiceA;

    @Column(nullable = false)
    private String choiceB;

    @Column(nullable = false)
    private String choiceC;

    @Column(nullable = false)
    private String choiceD;
}
