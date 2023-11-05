package com.aiquizgenerator.backend.grade.dtos;

import com.aiquizgenerator.backend.grade.labels.GradeLabels;
import jakarta.validation.constraints.NotBlank;

public class QuizGradeDTO {

    private Long id;
    @NotBlank(message = GradeLabels.QUIZ_ID_NOT_EMPTY)
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
