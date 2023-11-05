package com.aiquizgenerator.backend.data.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "quiz_grade")
public class QuizGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    private Quiz quiz;

    @JsonManagedReference
    @OneToMany(mappedBy = "quizGrade", cascade = CascadeType.ALL)
    private Set<QuizGradeQuestion> grades;

    private Boolean isQuizComplete;
}
