package com.pao.examdemo.domain.question;

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

    /*
    枚举年级类型
     */
    public enum Grade {
        PRIMARY1,PRIMARY2,PRIMARY3,PRIMARY4,PRIMARY5, PRIMARY6,
        MIDDLE1,MIDDLE2,MIDDLE3,
        SENIOR1,SENIOR2,SENIOR3
    }

    //年级
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Grade grade;

    //题干文本描述
    @Column(nullable = false)
    private String questionText;

    //知识点
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<KnowledgePoint> KnowledgePoints;

    //题目相关图片
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Image> images;

}
