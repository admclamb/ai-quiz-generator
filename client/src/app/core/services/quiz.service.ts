import { Injectable } from '@angular/core';
import { ExternalApiService } from './external-api.service';
import { Observable, mergeMap, of } from 'rxjs';
import { ApiResponseModel, RequestConfigModel } from '../models';
import { environment as env } from '../../../environments/environment';
import { QuizModel } from '../models/quiz.model';
import { PaginationResponseModel } from '../models/pagination-response.model';

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

  checkAnswer(
    quizId: number,
    questionId: number,
    answerId: number
  ): Observable<ApiResponseModel<boolean | null>> {
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
          data: data ? (data as boolean) : null,
          error,
        });
      })
    );
  }
}
