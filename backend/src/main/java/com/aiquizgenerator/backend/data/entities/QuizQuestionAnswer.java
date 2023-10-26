package com.aiquizgenerator.backend.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz_question_answer")
public class QuizQuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String answer;
}
