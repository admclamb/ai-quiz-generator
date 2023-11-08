package com.aiquizgenerator.backend.grade.dtos;

public class AddQuizGradeDTO {
    private Long gradeId;

    private QuizGradeQuestionDTO gradeQuestion;

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public QuizGradeQuestionDTO getGradeQuestion() {
        return gradeQuestion;
    }

    public void setGradeQuestion(QuizGradeQuestionDTO gradeQuestion) {
        this.gradeQuestion = gradeQuestion;
    }
}
