package com.aiquizgenerator.backend.quiz.controllers;

import com.aiquizgenerator.backend.common.pagination.dtos.PaginationDTO;
import com.aiquizgenerator.backend.common.pagination.labels.PaginationLabels;
import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.quiz.exceptions.FutureDateException;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

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
//        if(isInFuture(paginationDTO.getTimestamp())) {
//            throw new FutureDateException();
//        }
        return quizService.findAllPaginated(paginationDTO);
    }

    @GetMapping("/find")
    public Quiz findById(@RequestParam @NotBlank(message = QuizLabels.QUIZ_ID_NOT_EMPTY) Long id) {
        Quiz foundQuiz = quizService.findOneByIdWithoutAnswers(id);
        foundQuiz.getQuestions().forEach(question -> question.setCorrectAnswer(null));
        return foundQuiz;
    }

    private Boolean isInFuture(LocalDateTime timestamp) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println(currentDateTime.getHour() + "  " +  currentDateTime.getMinute());
        System.out.println(timestamp.getHour() + "  " +  timestamp.getMinute());
        return timestamp.isAfter(currentDateTime);
    }
}
