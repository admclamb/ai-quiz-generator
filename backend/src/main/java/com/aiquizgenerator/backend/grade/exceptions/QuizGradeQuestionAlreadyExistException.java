package com.aiquizgenerator.backend.grade.exceptions;

import com.aiquizgenerator.backend.grade.labels.QuizGradeLabels;

public class QuizGradeQuestionAlreadyExistException extends RuntimeException {
    public QuizGradeQuestionAlreadyExistException() { super(QuizGradeLabels.QUIZ_GRADE_QUESTION_ALREADY_EXIST);}
}
