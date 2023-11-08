package com.aiquizgenerator.backend.grade.exceptions;

import com.aiquizgenerator.backend.grade.labels.QuizGradeLabels;

public class QuizGradeNotFoundException extends RuntimeException {
    public QuizGradeNotFoundException() { super(QuizGradeLabels.QUIZ_GRADE_ID_NOT_FOUND);}
}
