package com.pao.examdemo.services.impl;

import com.pao.examdemo.domain.KnowledgePoint;
import com.pao.examdemo.domain.Paper;
import com.pao.examdemo.domain.Question;
import com.pao.examdemo.domain.School;
import com.pao.examdemo.exception.SavePaperException;
import com.pao.examdemo.repository.KPRepository;
import com.pao.examdemo.repository.PaperRepository;
import com.pao.examdemo.repository.QuestionRepository;
import com.pao.examdemo.repository.SchoolRepository;
import com.pao.examdemo.services.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private KPRepository kpRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private PaperRepository paperRepository;

    @Override
    public boolean savePaper(Paper paper) throws SavePaperException {
        //先查一下有没这个学校，有就不持久化
        School school = schoolRepository.findBySchoolName(paper.getPaperSchool().getSchoolName());
        if(school==null)
            school = paper.getPaperSchool();
        paper.setPaperSchool(school);
        //处理题目列表
        List<Question> questions = paper.getQuestions();
        List<KnowledgePoint> knowledgePoints;
        for(int i = 0;i<questions.size();i++){
            //如果这道题题库里有将抛出异常
            if(questionRepository.findByQuestionText(questions.get(i).getQuestionText())!=null){
                throw new SavePaperException("题目入库异常，该题在数据库中已有",i);
            }
            //遍历知识点，查一下数据库中是否存在,存在就别入库了
            knowledgePoints = questions.get(i).getKnowledgePoints();
            for(int j = 0;j<knowledgePoints.size();j++){
                KnowledgePoint tempKP = kpRepository.findByKnowledgePointName(knowledgePoints.get(j).getKnowledgePointName());
                if(tempKP!=null){
                    knowledgePoints.set(j,tempKP);
                }
            }

        }
        paperRepository.save(paper);
        return false;
    }
}
