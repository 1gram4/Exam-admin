package com.pao.examdemo.domain;

import javax.persistence.*;

@Entity
public class answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long answerId;

    @Column(nullable = false)
    private String answerText;
}
