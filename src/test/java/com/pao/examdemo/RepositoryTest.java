package com.pao.examdemo;

import com.pao.examdemo.domain.User;
import com.pao.examdemo.domain.enumeration.UserType;
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
        User user=new User();
        user.setUserType(UserType.KYE_BOARDER);
        user.setUserName("祝文康");
        user.setPassWord("123");
        user.setPhoneNumber("123456");
        userRepository.save(user);
    }
}
