package com.pao.examdemo.controller;

import com.pao.examdemo.domain.User;
import com.pao.examdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(value = "/test")
    public void test(){
        User user=new User();
        user.setUserName("paoge");
        user.setPhoneNumber("1112213");
        user.setPassWord("12123");
        userRepository.save(user);
    }
}
