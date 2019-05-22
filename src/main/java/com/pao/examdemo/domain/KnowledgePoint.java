package com.pao.examdemo.domain;

import javax.persistence.*;

@Entity
public class KnowledgePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long knowledgePointId;


    @Column(nullable = false)
    private String knowledgePointName;

    public Long getKnowledgePointId() {
        return knowledgePointId;
    }

    public void setKnowledgePointId(Long knowledgePointId) {
        this.knowledgePointId = knowledgePointId;
    }

    public String getKnowledgePointName() {
        return knowledgePointName;
    }

    public void setKnowledgePointName(String knowledgePointName) {
        this.knowledgePointName = knowledgePointName;
    }
}
