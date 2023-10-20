package com.aiquizgenerator.backend.data.entities.category;

import com.aiquizgenerator.backend.data.entities.quiz.Quiz;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany
    private Set<Quiz> quizes;
}
