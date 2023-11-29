package com.aiquizgenerator.backend.quiz.repositories;

import com.aiquizgenerator.backend.data.entities.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query("SELECT q FROM Quiz q WHERE q.createdAt <= :timestamp ORDER BY q.createdAt DESC")
    Page<Quiz> findAllBeforeTimestamp(Pageable page, LocalDateTime timestamp);

}
