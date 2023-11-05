package com.aiquizgenerator.backend.quiz.controllers;

import com.aiquizgenerator.backend.common.pagination.dtos.PaginationDTO;
import com.aiquizgenerator.backend.common.pagination.labels.PaginationLabels;
import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.data.entities.QuizQuestion;
import com.aiquizgenerator.backend.data.entities.QuizQuestionAnswer;
import com.aiquizgenerator.backend.quiz.exceptions.FutureDateException;
import com.aiquizgenerator.backend.quiz.exceptions.QuizQuestionAnswerNotFoundException;
import com.aiquizgenerator.backend.quiz.exceptions.QuizQuestionNotFoundException;
import com.aiquizgenerator.backend.quiz.labels.QuizLabels;
import com.aiquizgenerator.backend.quiz.services.QuizService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/quiz")
@CrossOrigin(origins = "http://localhost:4040")
public class QuizController  {
    private final QuizService quizService;

    @GetMapping()
    public Map<String, Object> listQuizes(
            @Valid @ModelAttribute PaginationDTO paginationDTO
    ) {
        return quizService.findAllPaginated(paginationDTO);
    }

    @GetMapping("/find")
    public Quiz findById(@RequestParam @NotBlank(message = QuizLabels.QUIZ_ID_NOT_EMPTY) Long id) {
        Quiz foundQuiz = quizService.findOneById(id);
        foundQuiz.getQuestions().forEach(question -> question.setCorrectAnswer(null));
        return foundQuiz;
    }

    @GetMapping("/check-answer")
    public Map<String, Boolean> checkAnswer(@RequestParam(required = true)Long quizId,@RequestParam(required = true) Long questionId,@RequestParam(required = true) Long answerId) {
        Quiz foundQuiz = quizService.findOneById(quizId);
        QuizQuestion foundQuestion = findQuestion(foundQuiz.getQuestions(), questionId);
        QuizQuestionAnswer foundAnswer = findAnswer(foundQuestion.getAnswers(), answerId);
        Map<String, Boolean> output = new HashMap<>();
        output.put("isCorrect", Objects.equals(foundAnswer.getAnswer(), foundQuestion.getCorrectAnswer()));
        return output;
    }

    private QuizQuestion findQuestion(Set<QuizQuestion> questions, Long questionId) throws QuizQuestionNotFoundException {
        for (QuizQuestion question : questions) {
            if (question.getId().equals(questionId)) {
                return question;
            }
        }
        throw new QuizQuestionNotFoundException();
    }

    private QuizQuestionAnswer findAnswer(Set<QuizQuestionAnswer> answers, Long answerId) throws QuizQuestionAnswerNotFoundException {
        for (QuizQuestionAnswer answer: answers) {
            if (answer.getId().equals(answerId)) {
                return answer;
            }
        }
        throw new QuizQuestionAnswerNotFoundException();
    }
}
