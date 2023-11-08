package com.aiquizgenerator.backend.grade.repositories;

import com.aiquizgenerator.backend.data.entities.QuizGradeQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizGradeQuestionRepository extends JpaRepository<QuizGradeQuestion, Long> {
}
