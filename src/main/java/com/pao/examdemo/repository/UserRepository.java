package com.pao.examdemo.repository;

import com.pao.examdemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserId(Long userId);
    User findByUserName(String userName);
    User findByUserNameAndPassWord(String userName,String passWord);
}
