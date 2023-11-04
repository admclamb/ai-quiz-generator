import { Component, EventEmitter, Input, Output } from '@angular/core';
import { QuestionAnswerModel } from 'src/app/core/models/question-answer.model';
import { QuestionModel } from 'src/app/core/models/question.model';
import { QuizService } from 'src/app/core/services/quiz.service';
import { AppErrorModel } from '@app/core';
import { QuizGradeModel } from 'src/app/core/models/quiz-grade.model';

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

  @Output() gradeAnswer = new EventEmitter<QuizGradeModel>();

  constructor(private quizService: QuizService) {}

  checkAnswer(answer: QuestionAnswerModel) {
    console.log('CLICKED: ', answer);
    this.error = null;
    this.quizService
      .checkAnswer(this.quizId, this.question.id, answer.id)
      .subscribe((response) => {
        const { data, error } = response;
        console.log(data);
        if (error) {
          this.error = error;
        }
        const answerResponse = {
          question: this.question,
          answer: answer,
          isCorrect: data === true,
        };
        console.log(answerResponse);
        this.gradeAnswer.emit(answerResponse);
      });
  }
}
