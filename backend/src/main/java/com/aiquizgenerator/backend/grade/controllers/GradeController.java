package com.aiquizgenerator.backend.grade.controllers;

import com.aiquizgenerator.backend.data.entities.QuizGrade;
import com.aiquizgenerator.backend.grade.dtos.QuizGradeDTO;
import com.aiquizgenerator.backend.grade.services.GradeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/grade")
@CrossOrigin(origins = "http://localhost:4040")
public class GradeController {
    private final GradeService gradeService;

    @PostMapping("/create")
    public QuizGrade createGrade(@RequestBody @Valid QuizGradeDTO quizGradeDTO) {
        return gradeService.create(quizGradeDTO);
    }

//    @PutMapping("/:gradeId/add")
//    public QuizGrade addGrade(QuizGradeDTO quizGradeDTO) {
//        QuizGrade foundQuizGrade = gradeRepository.findOneById(quizGradeDTO.getId());
//    }
}
