package com.aiquizgenerator.backend.grade.services;

import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.data.entities.QuizGrade;
import com.aiquizgenerator.backend.data.entities.QuizGradeQuestion;
import com.aiquizgenerator.backend.grade.repositories.GradeRepository;
import com.aiquizgenerator.backend.grade.repositories.QuizGradeQuestionRepository;
import com.aiquizgenerator.backend.quiz.repositories.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GradeService {
    private final GradeRepository gradeRepository;
    private final QuizRepository quizRepository;
    private final QuizGradeQuestionRepository quizGradeQuestionRepository;
    public QuizGrade create(QuizGrade quizGrade) {
        return gradeRepository.save(quizGrade);
    }

    public QuizGrade findOneById(Long id) { return gradeRepository.findById(id).orElse(null);}
    public Quiz findOneQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public QuizGradeQuestion addGradeQuestion(QuizGradeQuestion quizGradeQuestion) {
        return quizGradeQuestionRepository.save(quizGradeQuestion);
    }
}
