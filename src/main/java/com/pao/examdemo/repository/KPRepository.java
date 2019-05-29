package com.pao.examdemo.repository;

import com.pao.examdemo.domain.KnowledgePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KPRepository extends JpaRepository<KnowledgePoint,Long> {
    KnowledgePoint findByKnowledgePointName(String name);
}
