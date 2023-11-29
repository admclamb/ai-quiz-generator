package com.aiquizgenerator.backend.grade.exceptions;

import com.aiquizgenerator.backend.grade.labels.QuizGradeLabels;

public class QuizQuestionDoesNotExistException extends RuntimeException {
    public QuizQuestionDoesNotExistException() {
        super(QuizGradeLabels.QUIZ_QUESTION_DOES_NOT_EXIST);
    }
}
