package com.pao.examdemo.controller;

import com.pao.examdemo.domain.Paper;
import com.pao.examdemo.domain.Question;
import com.pao.examdemo.exception.SavePaperException;
import com.pao.examdemo.repository.PaperRepository;
import com.pao.examdemo.services.PaperService;
import com.pao.examdemo.utils.NetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
试卷控制层
 */
@RestController
@RequestMapping(value = "/api/v1")
public class PaperController {
    @Autowired
    private PaperService paperService;
    @Autowired
    private NetResult netResult;

    @RequestMapping(value="/addPaper")
    public NetResult addPaper(@RequestBody Paper paper){
        netResult.status = 0;
        netResult.result = "入库成功";
        try{
            paperService.savePaper(paper);
        }
        catch (SavePaperException e){
            e.printStackTrace();
            netResult.status = 1;
            netResult.result = netResult.status+"题数据库已有，请修改后重新提交";
        }
        return netResult;
    }
}
