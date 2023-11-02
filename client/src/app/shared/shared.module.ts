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
  ],
  imports: [CommonModule, RouterModule],
  exports: [...COMPONENTS],
})
export class SharedModule {}
