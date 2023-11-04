import { QuestionAnswerModel } from './question-answer.model';
import { QuestionModel } from './question.model';

export interface QuizGradeModel {
  question: QuestionModel;
  isCorrect: boolean;
  answer: QuestionAnswerModel;
}
