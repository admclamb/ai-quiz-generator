package com.aiquizgenerator.backend.grade.dtos;

import com.aiquizgenerator.backend.data.entities.QuizGrade;
import com.aiquizgenerator.backend.data.entities.QuizQuestion;
import com.aiquizgenerator.backend.data.entities.QuizQuestionAnswer;

public class QuizGradeQuestionDTO {

    private Long id;

    private QuizQuestion question;

    private QuizQuestionAnswer answer;

    private Boolean isCorrect;

    private QuizGrade quizGrade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuizQuestion getQuestion() {
        return question;
    }

    public void setQuestion(QuizQuestion question) {
        this.question = question;
    }

    public QuizQuestionAnswer getAnswer() {
        return answer;
    }

    public void setAnswer(QuizQuestionAnswer answer) {
        this.answer = answer;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public QuizGrade getQuizGrade() {
        return quizGrade;
    }

    public void setQuizGrade(QuizGrade quizGrade) {
        this.quizGrade = quizGrade;
    }
}
