package com.aiquizgenerator.backend.data.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "quiz_question")
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String question;


    @OneToMany(mappedBy = "quiz_question")
    private Set<QuizQuestionAnswer> answers;

    @OneToOne(mappedBy = "quiz_question")
    private QuizQuestionAnswer correctAnswer;
}
