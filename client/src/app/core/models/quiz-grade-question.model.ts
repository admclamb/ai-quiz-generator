import { QuestionAnswerModel } from './question-answer.model';
import { QuestionModel } from './question.model';
import { QuizGradeModel } from './quiz-grade.model';

export interface QuizGradeQuestionModel {
  id: number | null;
  question: QuestionModel;
  isCorrect: boolean;
  answer: QuestionAnswerModel;
  createdAt?: Date;
  updatedAt?: Date;
  quizGrade?: QuizGradeModel;
}
