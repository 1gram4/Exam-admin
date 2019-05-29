package com.pao.examdemo.services;

import com.pao.examdemo.domain.Paper;
import com.pao.examdemo.exception.SavePaperException;

public interface PaperService {
    public boolean savePaper(Paper paper) throws SavePaperException;
}
