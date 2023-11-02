import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '@auth0/auth0-angular';
import { NoAccountGuard } from './core/guards/no-account.guard';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    loadChildren: () =>
      import('./features/home/home.module').then((m) => m.HomeModule),
  },
  {
    path: 'create',
    pathMatch: 'full',
    loadChildren: () =>
      import('./features/create/create.module').then((m) => m.CreateModule),
  },
  {
    path: 'quiz/:quizId',
    loadChildren: () =>
      import('./features/quiz/quiz.module').then((m) => m.QuizModule),
  },
  {
    path: '**',
    loadChildren: () =>
      import('./features/not-found/not-found.module').then(
        (m) => m.NotFoundModule
      ),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
