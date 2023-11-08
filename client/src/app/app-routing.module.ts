import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    loadChildren: () =>
      import('./features/home/home.module').then((m) => m.HomeModule),
  },
  {
    path: 'browse',
    pathMatch: 'full',
    loadChildren: () =>
      import('./features/browse/browse.module').then((m) => m.BrowseModule),
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
