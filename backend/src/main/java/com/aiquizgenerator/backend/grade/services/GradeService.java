package com.aiquizgenerator.backend.grade.services;

import com.aiquizgenerator.backend.data.entities.QuizGrade;
import com.aiquizgenerator.backend.grade.dtos.QuizGradeDTO;
import com.aiquizgenerator.backend.grade.repositories.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    public QuizGrade create(QuizGradeDTO quizGradeDTO) {
        QuizGrade grade = new QuizGrade();
        BeanUtils.copyProperties(quizGradeDTO, grade);
        return gradeRepository.save(grade);
    }


}
