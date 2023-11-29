import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizCountdownComponent } from './quiz-countdown.component';

describe('QuizCountdownComponent', () => {
  let component: QuizCountdownComponent;
  let fixture: ComponentFixture<QuizCountdownComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [QuizCountdownComponent]
    });
    fixture = TestBed.createComponent(QuizCountdownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
