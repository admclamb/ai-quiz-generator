import { Component, Input } from '@angular/core';
import { QuestionModel } from 'src/app/core/models/question.model';
import { QuizGradeModel } from 'src/app/core/models/quiz-grade.model';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
})
export class QuizComponent {
  @Input() questions!: QuestionModel[];
  @Input() quizId!: number;

  hasGameStarted: boolean = true;
  isGameOver: boolean = false;
  currentQuestion: number = 0;

  quizGrade: QuizGradeModel[] = [];

  changeToNextQuestion() {
    this.currentQuestion++;
    if (!this.questions[this.currentQuestion]) {
      this.hasGameStarted = false;
      this.isGameOver = true;
    }
  }

  gradeAnswer(grade: QuizGradeModel) {
    this.quizGrade.push(grade);
    this.changeToNextQuestion();
  }
}
