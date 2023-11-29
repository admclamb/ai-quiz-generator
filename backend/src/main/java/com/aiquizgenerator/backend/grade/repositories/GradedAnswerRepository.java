package com.aiquizgenerator.backend.grade.repositories;

import com.aiquizgenerator.backend.data.entities.GradedAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradedAnswerRepository extends JpaRepository<GradedAnswer, Long> {
}
