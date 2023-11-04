import { Component, Input } from '@angular/core';
import { QuestionModel } from 'src/app/core/models/question.model';
import { QuizModel } from 'src/app/core/models/quiz.model';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css'],
})
export class QuizComponent {
  @Input() questions!: QuestionModel[];

  hasGameStarted: boolean = true;
  isGameOver: boolean = false;
  currentQuestion: number = 0;

  changeToNextQuestion() {
    this.currentQuestion++;
    if (!this.questions[this.currentQuestion]) {
      this.hasGameStarted = false;
      this.isGameOver = false;
    }
  }

  selectAnswer(index: number) {}
}
