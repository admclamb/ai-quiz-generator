import { Component, EventEmitter, Input, Output } from '@angular/core';
import { map, takeWhile, timer } from 'rxjs';

@Component({
  selector: 'app-quiz-countdown',
  templateUrl: './quiz-countdown.component.html',
})
export class QuizCountdownComponent {
  @Input() seconds = 300;

  @Output() onZero: EventEmitter<any> = new EventEmitter();

  timeRemaining$ = timer(0, 1000).pipe(
    map((n) => (this.seconds - n) * 1000),
    takeWhile((n) => n >= 0)
  );

  constructor() {
    this.timeRemaining$.subscribe((time) => {
      if (time === 0) {
        this.onEndCountdown();
      }
    });
  }

  onEndCountdown() {
    this.onZero.emit();
  }
}
