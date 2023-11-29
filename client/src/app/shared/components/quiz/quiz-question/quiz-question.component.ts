import { Component, EventEmitter, Input, Output } from '@angular/core';
import { QuestionAnswerModel } from 'src/app/core/models/question-answer.model';
import { QuestionModel } from 'src/app/core/models/question.model';
import { QuizService } from 'src/app/core/services/quiz.service';
import { AppErrorModel } from '@app/core';

@Component({
  selector: 'app-quiz-question',
  templateUrl: './quiz-question.component.html',
})
export class QuizQuestionComponent {
  @Input() question!: QuestionModel;
  @Input() correctAnswer: QuestionModel | null = null;
  @Input() incorrectAnswer: QuestionModel | null = null;

  @Output() gradeAnswer: EventEmitter<QuestionAnswerModel> = new EventEmitter();

  checkAnswer(answer: QuestionAnswerModel) {
    this.gradeAnswer.emit(answer);
  }
}
