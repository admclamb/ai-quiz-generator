package com.aiquizgenerator.backend.generator.services;


import com.aiquizgenerator.backend.data.entities.Category;
import com.aiquizgenerator.backend.data.entities.Quiz;
import com.aiquizgenerator.backend.data.entities.QuizQuestion;
import com.aiquizgenerator.backend.data.entities.QuizQuestionAnswer;
import com.aiquizgenerator.backend.generator.repositories.CategoryRepository;
import com.aiquizgenerator.backend.generator.repositories.QuizQuestionAnswerRepository;
import com.aiquizgenerator.backend.generator.repositories.QuizQuestionRepository;
import com.aiquizgenerator.backend.generator.repositories.QuizRepository;
import com.aiquizgenerator.backend.quiz.dtos.CreateQuizDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GeneratorService {
    private final QuizRepository quizRepository;
    private final QuizQuestionRepository quizQuestionRepository;
    private final QuizQuestionAnswerRepository quizQuestionAnswerRepository;
    private final CategoryRepository categoryRepository;

    public Quiz createQuiz(Quiz quiz) {
        Quiz createdQuiz = quizRepository.save(quiz);
        return createdQuiz;
    }

    public QuizQuestion createQuestion(QuizQuestion quizQuestion) {
        return quizQuestionRepository.save(quizQuestion);
    }

    public QuizQuestionAnswer createQuizQuestionAnswer(QuizQuestionAnswer answer) {
        return quizQuestionAnswerRepository.save(answer);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }
}