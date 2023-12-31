import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { COMPONENTS } from './components';
import { Auth0FeatureComponent } from './components/auth0-feature.component';
import { Auth0FeaturesComponent } from './components/auth0-features.component';
import { LoginButtonComponent } from './components/buttons/login-button.component';
import { LogoutButtonComponent } from './components/buttons/logout-button.component';
import { SignupButtonComponent } from './components/buttons/signup-button.component';
import { NavbarMobileComponent } from './components/navbar/navbar-mobile/navbar-mobile.component';
import { PageLayoutComponent } from './components/page-layout/page-layout.component';
import { LoadingComponent } from './components/loading/loading.component';
import { FeedComponent } from './components/feed/feed.component';
import { QuizQuestionComponent } from './components/quiz/quiz-question/quiz-question.component';
import { QuizComponent } from './components/quiz/quiz.component';
import { QuizCountdownComponent } from './components/quiz/quiz-countdown/quiz-countdown.component';

@NgModule({
  declarations: [
    ...COMPONENTS,
    Auth0FeaturesComponent,
    Auth0FeatureComponent,
    LoginButtonComponent,
    LogoutButtonComponent,
    SignupButtonComponent,
    NavbarMobileComponent,
    PageLayoutComponent,
    LoadingComponent,
    FeedComponent,
    QuizQuestionComponent,
    QuizComponent,
    QuizCountdownComponent,
  ],
  imports: [CommonModule, RouterModule],
  exports: [...COMPONENTS],
})
export class SharedModule {}
