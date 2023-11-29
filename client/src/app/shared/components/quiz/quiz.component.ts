import { Component, EventEmitter, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppErrorModel } from '@app/core';
import { QuestionAnswerModel } from 'src/app/core/models/question-answer.model';
import { QuestionModel } from 'src/app/core/models/question.model';
import { QuizGradeQuestionModel } from 'src/app/core/models/quiz-grade-question.model';
import { QuizGradeModel } from 'src/app/core/models/quiz-grade.model';
import { QuizModel } from 'src/app/core/models/quiz.model';
import { QuizService } from 'src/app/core/services/quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
})
export class QuizComponent {
  @Input() quizGrade!: QuizGradeModel;
  @Input() quiz!: QuizModel;

  currentQuestion: QuestionModel | null = null;
  correctAnswer: QuestionModel | null = null;
  incorrectAnswer: QuestionModel | null = null;

  error: AppErrorModel | null = null;

  hasGameStarted: boolean = false;
  isGameOver: boolean = false;

  constructor(private quizService: QuizService) {}

  selectQuestion() {
    const question = this.quiz.questions.find(
      (question) =>
        !this.quizGrade.quizGradeQuestions.some(
          (grade) => grade.question.id === question.id
        )
    );
    if (question) {
      this.currentQuestion = question;
    } else {
      this.isGameOver = true;
      this.hasGameStarted = false;
    }
  }

  startGame() {
    this.hasGameStarted = true;
    this.isGameOver = false;
    console.log(this.quizGrade);
    this.selectQuestion();
  }

  gradeAnswer(answer: QuestionAnswerModel) {
    if (this.currentQuestion) {
      const grade: QuizGradeQuestionModel = {
        id: null,
        question: this.currentQuestion,
        answer,
        isCorrect: false,
        quizGrade: this.quizGrade,
      };
      this.quizService
        .addGradeToQuiz(this.quizGrade.id, grade)
        .subscribe((response) => {
          const { data, error } = response;
          if (data) {
            this.quizGrade.quizGradeQuestions.push(data);
            this.selectQuestion();
          }
          if (error) {
            this.error = error;
          }
        });
    }
  }

  calculateCurrentQuestion(): number {
    return this.quizGrade.quizGradeQuestions.length + 1;
  }

  calculateTotalQuestions(): number {
    return this.quiz.questions.length;
  }
}
