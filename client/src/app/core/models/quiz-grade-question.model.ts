import { QuestionAnswerModel } from './question-answer.model';
import { QuestionModel } from './question.model';

export interface QuizGradeQuestionModel {
  id: number;
  question: QuestionModel;
  isCorrect: boolean;
  answer: QuestionAnswerModel;
  createdAt: Date;
  updatedAt: Date;
}
