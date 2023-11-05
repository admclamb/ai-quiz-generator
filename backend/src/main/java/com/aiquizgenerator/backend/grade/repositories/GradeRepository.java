package com.aiquizgenerator.backend.grade.repositories;

import com.aiquizgenerator.backend.data.entities.QuizGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<QuizGrade, Long> {
}
