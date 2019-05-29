package com.pao.examdemo.exception;

public class SavePaperException extends Exception {
    private  int questionNo;

    public SavePaperException(String message,int questionNo) {
        super(message);
        this.questionNo = questionNo;
    }

    public int getQuestionNo() {
        return this.questionNo;
    }
}
