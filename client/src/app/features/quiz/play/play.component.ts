import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppErrorModel } from '@app/core';
import { QuizGradeModel } from 'src/app/core/models/quiz-grade.model';
import { QuizModel } from 'src/app/core/models/quiz.model';
import { LoadingService } from 'src/app/core/services/loading.service';
import { QuizService } from 'src/app/core/services/quiz.service';

@Component({
  selector: 'app-play',
  templateUrl: './play.component.html',
  styleUrls: ['./play.component.css'],
})
export class PlayComponent {
  quizGrade: QuizGradeModel | null = null;
  error: AppErrorModel | null = null;

  constructor(
    private route: ActivatedRoute,
    private readonly quizService: QuizService,
    public loadingService: LoadingService
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
        const gradeId: string | null = params.get('gradeId');
        if (gradeId) {
          this.quizService.getGrade(parseInt(gradeId)).subscribe((response) => {
            const { data, error } = response;
            if (data) {
              this.quizGrade = data;
            }
            if (error) {
              this.error = error;
            }
          });
        }
      }
    });
  }
}
