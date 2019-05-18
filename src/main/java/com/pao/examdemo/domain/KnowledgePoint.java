package com.pao.examdemo.domain;

import javax.persistence.*;

@Entity
public class KnowledgePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long KnowledgePointId;

    @Column(nullable = false)
    private String KnowledgePointName;

    public Long getKnowledgePointId() {
        return KnowledgePointId;
    }

    public void setKnowledgePointId(Long knowledgePointId) {
        KnowledgePointId = knowledgePointId;
    }

    public String getKnowledgePointName() {
        return KnowledgePointName;
    }

    public void setKnowledgePointName(String knowledgePointName) {
        KnowledgePointName = knowledgePointName;
    }
}
