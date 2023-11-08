import { QuestionAnswerModel } from './question-answer.model';
import { QuestionModel } from './question.model';
import { QuizGradeQuestionModel } from './quiz-grade-question.model';
import { QuizModel } from './quiz.model';

export interface QuizGradeModel {
  id?: number;
  isQuizComplete: boolean;
  quiz?: QuizModel;
  grades: QuizGradeQuestionModel[];
}
