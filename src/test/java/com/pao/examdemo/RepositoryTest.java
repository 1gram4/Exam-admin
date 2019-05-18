package com.pao.examdemo;

import com.pao.examdemo.domain.User;
import com.pao.examdemo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void userTest(){
        if(userRepository.findByUserName("祝文康")!=null){
            System.out.println(2);
        }
        if(userRepository.findByUserName("z")!=null){
            System.out.println(1);
        }
        if(userRepository.findByUserNameAndPassWord("祝文康","123456")!=null){
            System.out.println("登陆成功");
        }
    }
}
