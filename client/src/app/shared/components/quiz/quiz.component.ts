import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuestionModel } from 'src/app/core/models/question.model';
import { QuizGradeQuestionModel } from 'src/app/core/models/quiz-grade-question.model';
import { QuizGradeModel } from 'src/app/core/models/quiz-grade.model';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
})
export class QuizComponent {
  @Input() questions!: QuestionModel[];
  @Input() quizId!: number;
  @Input() gradeId!: number;

  hasGameStarted: boolean = true;
  isGameOver: boolean = false;
  currentQuestion: number = 0;

  quizGrades: QuizGradeModel = {
    isQuizComplete: false,
    grades: [],
  };

  changeToNextQuestion() {
    this.currentQuestion++;
    if (!this.questions[this.currentQuestion]) {
      this.hasGameStarted = false;
      this.isGameOver = true;
    }
  }

  gradeAnswer(grade: QuizGradeQuestionModel) {
    console.log('=>', grade);
    this.quizGrades.grades.push(grade);
    this.changeToNextQuestion();
  }

  getScore() {
    const correctAnswers = this.quizGrades.grades.filter(
      (grade) => grade.isCorrect
    );
    return correctAnswers.length / this.quizGrades.grades.length;
  }
}
