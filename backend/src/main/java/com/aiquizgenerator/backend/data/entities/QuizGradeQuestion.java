package com.aiquizgenerator.backend.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz_question_grade")
public class QuizQuestionGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    private QuizQuestion question;

    @ManyToOne()
    private QuizQuestionAnswer answer;

    private Boolean isCorrect;
}
