import { CategoryModel } from './category.model';
import { QuestionModel } from './question.model';

export interface QuizModel {
  id: number;
  prompt: string;
  questions: QuestionModel[];
  categories: CategoryModel[];
}
