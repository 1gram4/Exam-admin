package com.pao.examdemo.domain;

import javax.persistence.*;
import java.util.List;

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

    //一个学校拥有的试卷方便查询，我就这么弄了
    @OneToMany(cascade = CascadeType.ALL,mappedBy ="paperSchool" )
    private List<Paper> papers;

    public List<Paper> getPapers() {
        return papers;
    }

    public void setPapers(List<Paper> papers) {
        this.papers = papers;
    }

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
