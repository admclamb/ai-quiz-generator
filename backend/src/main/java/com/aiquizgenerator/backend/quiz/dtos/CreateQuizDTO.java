package com.aiquizgenerator.backend.quiz.dtos;

import com.aiquizgenerator.backend.data.entities.Category;
import com.aiquizgenerator.backend.data.entities.QuizQuestion;

import java.util.Set;

public class CreateQuizDTO {
    private String prompt;

    private Set<QuizQuestion> questions;

    private Set<Category> categories;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
