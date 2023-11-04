import { QuestionAnswerModel } from './question-answer.model';
import { QuizModel } from './quiz.model';

export interface QuestionModel {
  id: number;
  question: string;
  quiz: QuizModel;
  answers: QuestionAnswerModel[];
  correctAnswer: QuestionAnswerModel;
}
