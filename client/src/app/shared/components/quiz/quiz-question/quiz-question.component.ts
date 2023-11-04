import { Component, EventEmitter, Input, Output } from '@angular/core';
import { QuestionAnswerModel } from 'src/app/core/models/question-answer.model';
import { QuestionModel } from 'src/app/core/models/question.model';

@Component({
  selector: 'app-quiz-question',
  templateUrl: './quiz-question.component.html',
  styleUrls: ['./quiz-question.component.css'],
})
export class QuizQuestionComponent {
  @Input() question!: QuestionModel;
  @Input() currentQuestionIndex!: number;
  @Input() totalAmountOfQuestions!: number;

  @Output() selectQuestionAnswer = new EventEmitter<number>();

  selectAnswer(index: number) {
    this.selectQuestionAnswer.emit(index);
  }
}
