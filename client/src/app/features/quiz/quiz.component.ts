import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppErrorModel } from '@app/core';
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
  error: AppErrorModel | null = null;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private readonly quizService: QuizService,
    public loadingService: LoadingService
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      const quizId: string | null = params.get('quizId');
      if (quizId) {
        this.quizService.getQuizById(parseInt(quizId)).subscribe((response) => {
          this.quiz = response.data;
        });
      }
    });
  }

  startQuiz() {
    this.error = null;
    if (this.quiz) {
      this.quizService.startQuiz(this.quiz.id).subscribe((response) => {
        const { data, error } = response;
        if (data && this.quiz) {
          this.router.navigate([`/quiz/${this.quiz.id}/play/${data.id}`]);
        }
        if (error) {
          this.error = error;
        }
        console.log(data, error);
      });
    }
  }
}
