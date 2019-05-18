package com.pao.examdemo.domain;

import javax.persistence.*;

/*
学校实体类
 */
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long schoolId;

    /*
    学校名称
     */
    @Column(nullable = false)
    private String schoolName;

    /*
    学校性质,现在还不知道是干什么用的
     */
    private String schoolMess;

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolMess() {
        return schoolMess;
    }

    public void setSchoolMess(String schoolMess) {
        this.schoolMess = schoolMess;
    }
}
