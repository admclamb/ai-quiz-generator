package com.aiquizgenerator.backend.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "quiz_question_grade")
public class QuizGradeQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    private QuizQuestion question;

    @ManyToOne()
    private QuizQuestionAnswer answer;

    private Boolean isCorrect;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private QuizGrade quizGrade;
}
