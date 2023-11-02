package com.aiquizgenerator.backend.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "quiz_question")
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Quiz quiz;

    @JsonManagedReference
    @OneToMany(mappedBy = "quizQuestion", cascade = CascadeType.ALL)
    private Set<QuizQuestionAnswer> answers;

    @Column(nullable = false)
    private int correctAnswerIndex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Set<QuizQuestionAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<QuizQuestionAnswer> answers) {
        this.answers = answers;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswer) {
        this.correctAnswerIndex = correctAnswer;
    }
}
