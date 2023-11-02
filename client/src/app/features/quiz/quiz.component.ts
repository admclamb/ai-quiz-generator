import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuizModel } from 'src/app/core/models/quiz.model';
import { LoadingService } from 'src/app/core/services/loading.service';
import { QuizService } from 'src/app/core/services/quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css'],
})
export class QuizComponent {
  quiz: QuizModel | null = null;

  constructor(
    private route: ActivatedRoute,
    private readonly quizService: QuizService,
    public loadingService: LoadingService
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      const quizId: string | null = params.get('quizId');
      if (quizId) {
        this.quizService.getQuizById(parseInt(quizId)).subscribe((response) => {
          console.log(response);
        });
      }
    });
  }
}
