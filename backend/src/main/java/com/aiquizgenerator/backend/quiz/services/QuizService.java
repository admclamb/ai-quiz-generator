package com.aiquizgenerator.backend.quiz.services;

import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.quiz.repositories.QuizRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuizService {
    private final QuizRepository quizRepository;


    @Transactional
    public Quiz findOneByIdWithoutAnswers(Long id) {
        return quizRepository.findById(id).orElse(null);
    }
}
