package com.aiquizgenerator.backend.quiz.controllers;

import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.quiz.labels.QuizLabels;
import com.aiquizgenerator.backend.quiz.services.QuizService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/quiz")
public class QuizController  {
    private final QuizService quizService;

    @GetMapping("/find")
    public Quiz findById(@RequestParam @NotBlank(message = QuizLabels.QUIZ_ID_NOT_EMPTY) Long id) {
        return quizService.findOneByIdWithoutAnswers(id);
    }
}
