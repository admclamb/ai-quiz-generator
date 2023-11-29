package com.aiquizgenerator.backend.quiz.repositories;

import com.aiquizgenerator.backend.data.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
