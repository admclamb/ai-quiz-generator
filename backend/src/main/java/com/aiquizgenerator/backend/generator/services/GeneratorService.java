package com.aiquizgenerator.backend.generator.services;


import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.generator.repositories.QuizRepository;
import com.aiquizgenerator.backend.quiz.dtos.CreateQuizDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GeneratorService {
    private final QuizRepository quizRepository;

    public Quiz createQuiz(Quiz quiz) {
        Quiz createdQuiz = quizRepository.save(quiz);
        return createdQuiz;
    }
}