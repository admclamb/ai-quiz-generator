package com.aiquizgenerator.backend.quiz.repositories;

import com.aiquizgenerator.backend.data.entities.QuizQuestion;
import org.springframework.data.repository.CrudRepository;

public interface QuizQuestionRepository extends CrudRepository<QuizQuestion, Long> {
}