import { ActivatedRoute, Router } from '@angular/router';
import { AppErrorModel } from '@app/core';
import { GeneratorService } from 'src/app/core/services/generator.service';
import { Component } from '@angular/core';
import { LoadingService } from 'src/app/core/services/loading.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css'],
})
export class CreateComponent {
  prompt: string = '';
  error: AppErrorModel | null = null;

  constructor(
    private readonly generatorService: GeneratorService,
    private router: Router,
    public loadingService: LoadingService
  ) {}

  createQuiz(event: Event) {
    event.preventDefault();
    this.error = null;
    if (this.prompt) {
      this.generatorService.generateQuiz(this.prompt).subscribe((response) => {
        const { data, error } = response;
        if (data) {
          this.router.navigate([`/quiz/${data.id}`]);
        }

        if (error) {
          this.error = error;
        }
      });
    }

    const example = {
      categories: [{ name: 'History' }, { name: 'Military' }, { name: 'WW2' }],
      questions: [
        {
          question: 'When was WW2?',
          answers: [
            { answer: 'September 1, 1939' },
            { answer: 'January 2, 2001' },
            { answer: 'May 4, 1998' },
            { answer: 'October 4, 1900' },
          ],
          correctAnswer: 'September 1, 1939',
        },
      ],
    };
  }
}
