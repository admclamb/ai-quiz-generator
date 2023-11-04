import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QuizComponent } from './quiz.component';
import { SharedModule } from '@app/shared';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [QuizComponent],
  imports: [
    CommonModule,
    SharedModule,
    FormsModule,
    RouterModule.forChild([
      { path: '', component: QuizComponent },
      {
        path: 'play',
        loadChildren: () =>
          import('./play/play.module').then((m) => m.PlayModule),
      },
    ]),
  ],
})
export class QuizModule {}
