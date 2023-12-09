package com.aiquizgenerator.backend.data.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Quiz quiz;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "grade")
    private List<GradedAnswer> gradedAnswers;

    @Column(nullable = false)
    private Boolean isQuizComplete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<GradedAnswer> getGradedAnswers() {
        return gradedAnswers;
    }

    public void setGradedAnswers(List<GradedAnswer> gradedAnswers) {
        this.gradedAnswers = gradedAnswers;
    }

    public Boolean getQuizComplete() {
        return isQuizComplete;
    }

    public void setQuizComplete(Boolean quizComplete) {
        isQuizComplete = quizComplete;
    }
}
