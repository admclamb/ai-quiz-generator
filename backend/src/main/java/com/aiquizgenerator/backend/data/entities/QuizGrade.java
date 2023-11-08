package com.aiquizgenerator.backend.data.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

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

    @ColumnDefault("false")
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

    public Set<QuizGradeQuestion> getGrades() {
        return grades;
    }

    public void setGrades(Set<QuizGradeQuestion> grades) {
        this.grades = grades;
    }

    public Boolean getQuizComplete() {
        return isQuizComplete;
    }

    public void setQuizComplete(Boolean quizComplete) {
        isQuizComplete = quizComplete;
    }
}
