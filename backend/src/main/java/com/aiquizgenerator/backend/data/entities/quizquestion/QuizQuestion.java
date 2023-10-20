package com.aiquizgenerator.backend.data.entities.quizquestion;

import com.aiquizgenerator.backend.data.entities.quiz.Quiz;
import jakarta.persistence.*;

@Entity
@Table(name = "quiz_question")
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="quiz_id", nullable = false)
    private Quiz quiz;
}
