package com.aiquizgenerator.backend.generator.services;


import com.aiquizgenerator.backend.data.entities.Category;
import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.data.entities.QuizQuestion;
import com.aiquizgenerator.backend.data.entities.QuizQuestionAnswer;
import com.aiquizgenerator.backend.generator.repositories.CategoryRepository;
import com.aiquizgenerator.backend.generator.repositories.QuizQuestionAnswerRepository;
import com.aiquizgenerator.backend.generator.repositories.QuizQuestionRepository;
import com.aiquizgenerator.backend.generator.repositories.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class GeneratorService {
    private final QuizRepository quizRepository;

    public Quiz createQuiz(Quiz quiz) { return  quizRepository.save(quiz);}
}