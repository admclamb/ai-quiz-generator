package com.aiquizgenerator.backend.data.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String prompt;

    @OneToMany(mappedBy = "quiz")
    private Set<QuizQuestion> questions;

    @ManyToMany
    private Set<Category> categories;
}
