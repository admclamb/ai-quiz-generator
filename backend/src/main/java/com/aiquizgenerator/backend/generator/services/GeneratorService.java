package com.aiquizgenerator.backend.generator.services;


import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.quiz.repositories.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GeneratorService {
    private final QuizRepository quizRepository;

    public Quiz createQuiz(Quiz quiz) { return  quizRepository.save(quiz);}
}