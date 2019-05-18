package com.pao.examdemo.domain;

import com.pao.examdemo.domain.question.Question;

import javax.persistence.*;
import java.util.Date;

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
}
