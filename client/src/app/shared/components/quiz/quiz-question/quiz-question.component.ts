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
  @Input() currentQuestionIndex!: number;
  @Input() totalAmountOfQuestions!: number;
  @Input() quizId!: number;

  error: AppErrorModel | null = null;

  @Output() gradeAnswer: EventEmitter<any> = new EventEmitter();

  constructor(private quizService: QuizService) {}

  checkAnswer(answer: QuestionAnswerModel) {
    this.error = null;
    this.quizService
      .checkAnswer(this.quizId, this.question.id, answer.id)
      .subscribe((response) => {
        const { data, error } = response;
        if (data) {
          this.gradeAnswer.emit({
            question: this.question,
            answer: answer,
            isCorrect: data.isCorrect,
          });
        }
        if (error) {
          this.error = error;
        }
      });
  }
}
