package com.aiquizgenerator.backend.generator.repositories;

import com.aiquizgenerator.backend.data.entities.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
