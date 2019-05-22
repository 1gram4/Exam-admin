package com.pao.examdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @RequestMapping(value = "/loginPage" ,method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }
    @RequestMapping(value = "/indexPage")
    public String indexPage(){
        return "index";
    }
    @RequestMapping(value = "/messagePage")
    public String messagePage(HttpServletRequest request){

        return "message";
    }
    @RequestMapping(value = "/questionsInputPage")
    public String questionsInputPage(){
        return "questionsInput";
    }
    @RequestMapping(value = "/questionsAdminPage")
    public String questionsAdmin(){
        return "questionsAdmin";
    }
    @RequestMapping(value = "/paperDetailsPage")
    public String paperDetails(){
        return "paperDetails";
    }
    @RequestMapping(value="/makePaperPage")
    public String makePaperPage(){
        return "makePaper";
    }
}
