package com.pao.examdemo.domain;

import javax.persistence.*;

@Entity
public class ExplainImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String imgPath;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
