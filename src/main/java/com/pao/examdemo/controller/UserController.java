package com.pao.examdemo.controller;

import com.pao.examdemo.domain.User;
import com.pao.examdemo.repository.UserRepository;
import com.pao.examdemo.utils.NetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NetResult netResult;

    @RequestMapping(value="/login")
    public NetResult login(@RequestBody User loginUser, HttpSession httpSession){
        User user=userRepository.findByUserName(loginUser.getUserName());
        if(user==null){
            netResult.status = -1;
            netResult.result = "用户不存在！";
        } else {
            if (loginUser.getPassWord()!=null){
                if (loginUser.getPassWord().equals(user.getPassWord())){
                    netResult.status=0;
                    netResult.result="登陆成功！";
                    httpSession.setAttribute(User.CUR_USER,user);
                } else{
                    netResult.status=-2;
                    netResult.result="密码错误";
                }
            } else{
                netResult.status = -3;
                netResult.result = "内部错误：密码为空！";
            }
        }
        return netResult;
    }

    //由于我们的项目并不是完全前后端分离项目，所以我这里就不返回公用结果了，直接跳转
    @RequestMapping(value = "/logout")
    public NetResult logout(HttpSession session, HttpServletResponse response) {
        User currentUser = (User)session.getAttribute(User.CUR_USER);
        if (null != currentUser) {
            session.removeAttribute(User.CUR_USER);
            netResult.status = 0;
            netResult.result = "注销成功";
            try{
                response.sendRedirect("/loginPage");//这里写得不好
            }
            catch (IOException e){
                e.printStackTrace();
            }

        } else {
            netResult.status = -1;
            netResult.result = "未登录或登陆状态已经过期，无需注销";
            try{
                response.sendRedirect("/loginPage");//这里写得不好
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return netResult;
    }

    @RequestMapping(value = "/getUserInfo")
    public NetResult getUserInfo (HttpSession session) {
        User user = (User) session.getAttribute(User.CUR_USER);
        if (user != null) {
            netResult.status = 0;
            netResult.result = user;
        } else {
            netResult.status = -1;
            netResult.result = "未登录或登录已过期！";
        }
        return netResult;
    }
}
