package com.aiquizgenerator.backend.quiz.dtos;

import java.util.Set;

public class QuizQuestionDTO {
    private String question;

    private Set<QuizQuestionAnswerDTO> answers;

    private QuizQuestionAnswerDTO correctAnswer;
}
