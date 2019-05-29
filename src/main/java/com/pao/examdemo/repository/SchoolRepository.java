package com.pao.examdemo.repository;

import com.pao.examdemo.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {
    School findBySchoolName(String schoolName);
}
