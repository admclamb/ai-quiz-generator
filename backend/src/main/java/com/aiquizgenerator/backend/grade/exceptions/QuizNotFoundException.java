package com.aiquizgenerator.backend.grade.exceptions;

import com.aiquizgenerator.backend.grade.labels.QuizGradeLabels;

public class QuizNotFoundException extends RuntimeException {
    public QuizNotFoundException() { super(QuizGradeLabels.QUIZ_ID_NOT_FOUND);}
}
