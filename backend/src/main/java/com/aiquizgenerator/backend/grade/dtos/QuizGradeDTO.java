package com.aiquizgenerator.backend.grade.dtos;

import com.aiquizgenerator.backend.grade.labels.QuizGradeLabels;
import jakarta.validation.constraints.NotNull;

public class QuizGradeDTO {

    private Long id;
    @NotNull(message = QuizGradeLabels.QUIZ_ID_NOT_EMPTY)
    private Long quizId;

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
