package com.pao.examdemo.domain;

import com.pao.examdemo.domain.enumeration.UserType;

import javax.persistence.*;

@Entity
public class User {
    public static final String CUR_USER = "currentUser";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long userId;

    /*
    用户名
     */
    @Column(nullable = false)
    private String userName;

    /*
    密码的md5值
     */
    @Column(nullable = false)
    private String passWord;

    /*
    电话号码
     */
    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private UserType userType;

    public static String getCurUser() {
        return CUR_USER;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
