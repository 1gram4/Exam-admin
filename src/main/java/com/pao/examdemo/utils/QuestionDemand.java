package com.pao.examdemo.utils;

import com.pao.examdemo.domain.School;
import com.pao.examdemo.domain.enumeration.Grade;
import com.pao.examdemo.domain.enumeration.QuestionType;
import com.pao.examdemo.domain.enumeration.Subject;

public class QuestionDemand {
    School school;
    Subject subject;
    Grade grade;
    QuestionType questionType;
    int Difficulty;

    private  QuestionDemand(){

    };

    public class Builder{
        private School school;
        private Subject subject;
        private Grade grade;
        private QuestionType questionType;
        private int Difficulty;

        public Builder(){

        }

        public Builder setSchool(School school) {
            this.school = school;
            return this;
        }

        public Builder setSubject(Subject subject) {
            this.subject = subject;
            return this;
        }

        public Builder setGrade(Grade grade) {
            this.grade = grade;
            return this;
        }

        public Builder setQuestionType(QuestionType questionType) {
            this.questionType = questionType;
            return this;
        }

        public Builder setDifficulty(int difficulty) {
            Difficulty = difficulty;
            return this;
        }

        public QuestionDemand build(){
            QuestionDemand questionDemand = new QuestionDemand();
            questionDemand.Difficulty = this.Difficulty;
            questionDemand.grade = this.grade;
            questionDemand.questionType = this.questionType;
            questionDemand.school = this.school;
            questionDemand.subject = this.subject;
            return questionDemand;
        }
    }
}
