package com.aiquizgenerator.backend.quiz.repositories;

import com.aiquizgenerator.backend.data.entities.QuizQuestionAnswer;
import org.springframework.data.repository.CrudRepository;

public interface QuizQuestionAnswerRepository extends CrudRepository<QuizQuestionAnswer, Long> {
}
