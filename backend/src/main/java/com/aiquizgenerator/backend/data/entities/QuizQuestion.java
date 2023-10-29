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

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "quizQuestion", cascade = CascadeType.ALL)
    private Set<QuizQuestionAnswer> answers;

    @OneToOne(mappedBy = "quizQuestion")
    private QuizQuestionAnswer correctAnswer;

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

    public QuizQuestionAnswer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(QuizQuestionAnswer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
