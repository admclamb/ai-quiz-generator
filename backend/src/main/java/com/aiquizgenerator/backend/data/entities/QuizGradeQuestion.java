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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuizQuestion getQuestion() {
        return question;
    }

    public void setQuestion(QuizQuestion question) {
        this.question = question;
    }

    public QuizQuestionAnswer getAnswer() {
        return answer;
    }

    public void setAnswer(QuizQuestionAnswer answer) {
        this.answer = answer;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public QuizGrade getQuizGrade() {
        return quizGrade;
    }

    public void setQuizGrade(QuizGrade quizGrade) {
        this.quizGrade = quizGrade;
    }
}
