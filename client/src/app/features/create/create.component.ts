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
  }
}
