package com.aiquizgenerator.backend.vendors.openai.services;

import com.aiquizgenerator.backend.data.entities.Answer;
import com.aiquizgenerator.backend.data.entities.Category;
import com.aiquizgenerator.backend.data.entities.Question;
import com.aiquizgenerator.backend.quiz.repositories.AnswerRepository;
import com.aiquizgenerator.backend.quiz.repositories.CategoryRepository;
import com.aiquizgenerator.backend.quiz.repositories.QuestionRepository;
import com.aiquizgenerator.backend.quiz.repositories.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OpenaiCrudService {
    private final CategoryRepository categoryRepository;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public Category findOrSaveCategory(Category category) {
        Category foundCategory = categoryRepository.findByName(category.getName());
        if (foundCategory != null) {
            return foundCategory;
        }
        return categoryRepository.save(category);
    }

    public List<Answer> saveAnswers(List<Answer> answers) {
        return answerRepository.saveAll(answers);
    }

    public List<Question> saveQuestions(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }
}
