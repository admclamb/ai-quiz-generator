import { Injectable } from '@angular/core';
import { ExternalApiService } from './external-api.service';
import { ApiResponseModel, RequestConfigModel } from '../models';
import { environment as env } from '../../../environments/environment';
import { QuizModel } from '../models/quiz.model';
import { Observable, mergeMap, of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class GeneratorService {
  constructor(public externalApiService: ExternalApiService) {}

  generateQuiz(prompt: string): Observable<ApiResponseModel<QuizModel | null>> {
    const config: RequestConfigModel = {
      url: `${env.api.serverUrl}/api/generator/generate`,
      method: 'POST',
      headers: {
        'content-type': 'application/json',
      },
      body: {
        prompt,
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
}
