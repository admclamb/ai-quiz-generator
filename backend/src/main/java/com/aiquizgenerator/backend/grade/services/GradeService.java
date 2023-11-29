package com.aiquizgenerator.backend.grade.services;

import com.aiquizgenerator.backend.data.entities.Grade;
import com.aiquizgenerator.backend.data.entities.GradedAnswer;
import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.grade.repositories.GradeRepository;
import com.aiquizgenerator.backend.grade.repositories.GradedAnswerRepository;
import com.aiquizgenerator.backend.quiz.repositories.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GradeService {
    private final GradeRepository gradeRepository;
    private final QuizRepository quizRepository;
    private final GradedAnswerRepository gradedAnswerRepository;
    public Grade create(Grade quizGrade) {
        return gradeRepository.save(quizGrade);
    }

    public Grade findOneById(Long id) {
        return gradeRepository.findById(id).orElse(null);
    }

    public Grade findOneByIdWithQuiz(Long id) {
        return gradeRepository.findById(id).orElse(null);
    }
    public Quiz findOneQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public GradedAnswer addGradeQuestion(GradedAnswer quizGradeQuestion) {
        return gradedAnswerRepository.save(quizGradeQuestion);
    }
}
