package com.aiquizgenerator.backend.quiz.exceptions;

import com.aiquizgenerator.backend.quiz.labels.QuizLabels;

public class QuizQuestionNotFoundException extends RuntimeException {
    public QuizQuestionNotFoundException() { super(QuizLabels.QUESTION_NOT_FOUND);}
}
