import { Component, Input } from '@angular/core';
import { AppErrorModel } from '@app/core';
import * as dayjs from 'dayjs';
import { QuizModel } from 'src/app/core/models/quiz.model';
import { LoadingService } from 'src/app/core/services/loading.service';
import { QuizService } from 'src/app/core/services/quiz.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
})
export class FeedComponent {
  quizes: QuizModel[] = [];
  error: AppErrorModel | null = null;

  @Input() page: number = 1;

  @Input() totalPages: number = 1;
  @Input() isEnd: boolean = false;

  @Input() size: number = 10;
  isSizeDropdownOpen: boolean = false;

  currentTimestamp: Date = new Date();

  constructor(
    public quizService: QuizService,
    public loadingService: LoadingService
  ) {}

  ngOnInit() {
    this.fetchQuizes();
  }

  changePage(newPage: number) {
    this.page = newPage;
    this.fetchQuizes();
  }

  changeSize(newSize: number) {
    this.size = newSize;
    this.isSizeDropdownOpen = false;
    this.quizes = [];
    this.fetchQuizes();
  }

  fetchQuizes() {
    this.error = null;
    this.quizService
      .getQuizesPageable(this.page, this.size, this.currentTimestamp)
      .subscribe((response) => {
        const { data, error } = response;
        if (data) {
          this.quizes = data.content;
          if (data.page >= data.totalPages) {
            this.isEnd = false;
          }
        }
        if (error) {
          this.error = error;
        }
      });
  }

  toggleSizeDropdown(): void {
    this.isSizeDropdownOpen = !this.isSizeDropdownOpen;
  }

  closeSizeDropdown(): void {
    this.isSizeDropdownOpen = false;
  }
}
