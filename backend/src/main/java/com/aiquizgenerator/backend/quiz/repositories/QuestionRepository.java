package com.aiquizgenerator.backend.quiz.repositories;

import com.aiquizgenerator.backend.data.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
