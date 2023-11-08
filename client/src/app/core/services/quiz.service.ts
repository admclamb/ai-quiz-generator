import { Injectable } from '@angular/core';
import { ExternalApiService } from './external-api.service';
import { Observable, mergeMap, of } from 'rxjs';
import { ApiResponseModel, RequestConfigModel } from '../models';
import { environment as env } from '../../../environments/environment';
import { QuizModel } from '../models/quiz.model';
import { PaginationResponseModel } from '../models/pagination-response.model';
import { QuizGradeModel } from '../models/quiz-grade.model';
import { QuizGradeQuestionModel } from '../models/quiz-grade-question.model';

@Injectable({
  providedIn: 'root',
})
export class QuizService {
  constructor(public externalApiService: ExternalApiService) {}

  getQuizesPageable(
    page: number,
    size: number,
    timestamp: Date
  ): Observable<ApiResponseModel<PaginationResponseModel<QuizModel> | null>> {
    const config: RequestConfigModel = {
      url: `${env.api.serverUrl}/api/v1/quiz?page=${encodeURIComponent(
        page
      )}&size=${encodeURIComponent(size)}&timestamp=${encodeURIComponent(
        timestamp.toISOString()
      )}`,
      method: 'GET',
      headers: {
        'content-type': 'application/json',
      },
    };

    return this.externalApiService.callExternalApi(config).pipe(
      mergeMap((response) => {
        const { data, error } = response;

        return of({
          data: data ? (data as PaginationResponseModel<QuizModel>) : null,
          error,
        });
      })
    );
  }

  getQuizById(id: number): Observable<ApiResponseModel<QuizModel | null>> {
    const config: RequestConfigModel = {
      url: `${env.api.serverUrl}/api/v1/quiz/find?id=${encodeURIComponent(id)}`,
      method: 'GET',
      headers: {
        'content-type': 'application/json',
      },
    };

    return this.externalApiService.callExternalApi(config).pipe(
      mergeMap((response) => {
        const { data, error } = response;

        return of({
          data: data ? (data as QuizModel) : null,
          error,
        });
      })
    );
  }

  getGrade(
    gradeId: number
  ): Observable<ApiResponseModel<QuizGradeModel | null>> {
    const config: RequestConfigModel = {
      url: `${env.api.serverUrl}/api/v1/grade/find?id=${encodeURIComponent(
        gradeId
      )}`,
      method: 'GET',
      headers: {
        'content-type': 'application/json',
      },
    };

    return this.externalApiService.callExternalApi(config).pipe(
      mergeMap((response) => {
        const { data, error } = response;
        return of({
          data: data ? (data as QuizGradeModel) : null,
          error,
        });
      })
    );
  }

  startQuiz(
    quizId: number
  ): Observable<ApiResponseModel<QuizGradeModel | null>> {
    const config: RequestConfigModel = {
      url: `${env.api.serverUrl}/api/v1/grade/create`,
      method: 'POST',
      headers: {
        'content-type': 'application/json',
      },
      body: {
        quizId,
      },
    };

    return this.externalApiService.callExternalApi(config).pipe(
      mergeMap((response) => {
        const { data, error } = response;
        return of({
          data: data ? (data as QuizGradeModel) : null,
          error,
        });
      })
    );
  }

  addGradeToQuiz(gradeId: number, grade: QuizGradeQuestionModel) {
    const config: RequestConfigModel = {
      url: `${env.api.serverUrl}/api/v1/grade/add`,
      method: 'POST',
      headers: {
        'content-type': 'application/json',
      },
      body: {
        gradeId,
        grade,
      },
    };

    return this.externalApiService.callExternalApi(config).pipe(
      mergeMap((response) => {
        const { data, error } = response;
        return of({
          data: data ? (data as QuizGradeModel) : null,
          error,
        });
      })
    );
  }

  checkAnswer(
    quizId: number,
    questionId: number,
    answerId: number
  ): Observable<ApiResponseModel<{ isCorrect: boolean } | null>> {
    const config: RequestConfigModel = {
      url: `${
        env.api.serverUrl
      }/api/v1/quiz/check-answer?quizId=${encodeURIComponent(
        quizId
      )}&questionId=${encodeURIComponent(questionId)}&answerId=${answerId}`,
      method: 'GET',
      headers: {
        'content-type': 'application/json',
      },
    };

    return this.externalApiService.callExternalApi(config).pipe(
      mergeMap((response) => {
        const { data, error } = response;
        return of({
          data: data ? (data as { isCorrect: boolean }) : null,
          error,
        });
      })
    );
  }
}
