package com.aiquizgenerator.backend.grade.controllers;

import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.data.entities.QuizGrade;
import com.aiquizgenerator.backend.data.entities.QuizGradeQuestion;
import com.aiquizgenerator.backend.grade.dtos.AddQuizGradeDTO;
import com.aiquizgenerator.backend.grade.dtos.QuizGradeDTO;
import com.aiquizgenerator.backend.grade.dtos.QuizGradeQuestionDTO;
import com.aiquizgenerator.backend.grade.exceptions.QuizGradeNotFoundException;
import com.aiquizgenerator.backend.grade.exceptions.QuizNotFoundException;
import com.aiquizgenerator.backend.grade.labels.QuizGradeLabels;
import com.aiquizgenerator.backend.grade.services.GradeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/grade")
@CrossOrigin(origins = "http://localhost:4040")
public class GradeController {
    private final GradeService gradeService;

    @PostMapping("/create")
    public QuizGrade createQuizGrade(@Valid @RequestBody QuizGradeDTO quizGradeDTO) {
        Quiz foundQuiz = gradeService.findOneQuizById(quizGradeDTO.getQuizId());
        if (foundQuiz == null) {
            throw new QuizNotFoundException();
        }
        QuizGrade quizGrade = new QuizGrade();
        quizGrade.setQuiz(foundQuiz);
        return gradeService.create(quizGrade);
    }

    @GetMapping("/find")
    public QuizGrade findQuizGrade(@RequestParam @NotBlank(message = QuizGradeLabels.QUIZ_GRADE_ID_NOT_FOUND) Long id) {
        QuizGrade foundGrade = gradeService.findOneById(id);
        foundGrade.getQuiz().getQuestions().forEach(question -> question.setCorrectAnswer(null));
        return foundGrade;
    }

    @PostMapping("/add")
    public Map<String, Boolean> addGrade(@Valid @RequestBody AddQuizGradeDTO addQuizGradeDTO) {
        QuizGrade foundQuizGrade = gradeService.findOneById(addQuizGradeDTO.getGradeId());
        if (foundQuizGrade == null ) {
            throw new QuizGradeNotFoundException();
        }
        addQuizGradeDTO.getGradeQuestion().setQuizGrade(foundQuizGrade);
        QuizGradeQuestion gradeQuestion = mapToGradeQuestionEntity(addQuizGradeDTO);
        gradeQuestion.setCorrect(checkAnswer(gradeQuestion));
        QuizGradeQuestion createdQuizGradeQuestion = gradeService.addGradeQuestion(gradeQuestion);
        Map<String, Boolean> output = new HashMap<>();
        output.put("isCorrect", createdQuizGradeQuestion.getCorrect());
        return output;
    }

    private Boolean checkAnswer(QuizGradeQuestion quizGradeQuestion) {
        return Objects.equals(quizGradeQuestion.getAnswer().getAnswer(), quizGradeQuestion.getQuestion().getCorrectAnswer());
    }

    private QuizGradeQuestion mapToGradeQuestionEntity(AddQuizGradeDTO addQuizGradeDTO) {
        QuizGradeQuestion gradeQuestion = new QuizGradeQuestion();
        QuizGradeQuestionDTO gradeQuestionDTO =  addQuizGradeDTO.getGradeQuestion();
        gradeQuestion.setQuestion(gradeQuestionDTO.getQuestion());
        gradeQuestion.setAnswer(gradeQuestionDTO.getAnswer());
        gradeQuestion.setCorrect(gradeQuestionDTO.getCorrect());
        gradeQuestion.setQuizGrade(gradeQuestionDTO.getQuizGrade());
        return gradeQuestion;
    }
}
