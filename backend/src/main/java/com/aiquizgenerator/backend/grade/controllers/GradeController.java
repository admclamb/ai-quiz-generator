package com.aiquizgenerator.backend.grade.controllers;

import com.aiquizgenerator.backend.data.entities.Grade;
import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.grade.dtos.CreateGradeRequest;
import com.aiquizgenerator.backend.grade.exceptions.QuizNotFoundException;
import com.aiquizgenerator.backend.grade.labels.QuizGradeLabels;
import com.aiquizgenerator.backend.grade.services.GradeService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/grade")
@CrossOrigin(origins = "http://localhost:4040")
public class GradeController {
    private final GradeService gradeService;

    @PostMapping("/create")
    public Grade createQuizGrade(@Valid @RequestBody CreateGradeRequest createGradeRequest) {
        Quiz foundQuiz = gradeService.findOneQuizById(createGradeRequest.getQuizId());
        if (foundQuiz == null) {
            throw new QuizNotFoundException();
        }
        Grade quizGrade = new Grade();
        quizGrade.setQuiz(foundQuiz);
        quizGrade.setQuizComplete(false);
        return gradeService.create(quizGrade);
    }

    @GetMapping("/find")
    @JsonIgnore()
    public Grade findQuizGrade(@RequestParam @NotBlank(message = QuizGradeLabels.QUIZ_GRADE_ID_NOT_FOUND) Long id) {
        Grade foundGrade = gradeService.findOneById(id);
        foundGrade.getQuiz().getQuestions().forEach(question -> question.setCorrectAnswer(null));
        return foundGrade;
    }
}

