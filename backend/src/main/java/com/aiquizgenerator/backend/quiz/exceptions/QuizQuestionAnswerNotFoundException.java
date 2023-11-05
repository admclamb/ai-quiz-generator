package com.aiquizgenerator.backend.quiz.exceptions;

import com.aiquizgenerator.backend.quiz.labels.QuizLabels;

public class QuizQuestionAnswerNotFoundException extends RuntimeException {
    public QuizQuestionAnswerNotFoundException() { super(QuizLabels.ANSWER_NOT_FOUND);}
}
