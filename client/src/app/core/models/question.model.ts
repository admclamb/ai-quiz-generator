import { QuestionAnswerModel } from './question-answer.model';
import { QuizModel } from './quiz.model';

export interface QuestionModel {
  id: string;
  question: string;
  quiz: QuizModel;
  answers: QuestionAnswerModel[];
  correctAnswer: QuestionAnswerModel;
}
