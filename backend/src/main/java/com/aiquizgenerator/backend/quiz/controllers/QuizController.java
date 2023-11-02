package com.aiquizgenerator.backend.quiz.controllers;

import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.quiz.labels.QuizLabels;
import com.aiquizgenerator.backend.quiz.services.QuizService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/quiz")
@CrossOrigin(origins = "http://localhost:4040")
public class QuizController  {
    private final QuizService quizService;

    @GetMapping("/find")
    public Quiz findById(@RequestParam @NotBlank(message = QuizLabels.QUIZ_ID_NOT_EMPTY) Long id) {
        Quiz foundQuiz = quizService.findOneByIdWithoutAnswers(id);
        foundQuiz.getQuestions().forEach(question -> question.setCorrectAnswer(null));
        return foundQuiz;
    }
}
