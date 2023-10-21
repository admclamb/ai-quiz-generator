import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateComponent } from './create.component';
import { RouterModule } from '@angular/router';
import { SharedModule } from '@app/shared';
import { HomeComponent } from '../home/home.component';

@NgModule({
  declarations: [CreateComponent],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild([{ path: '', component: HomeComponent }]),
  ],
})
export class CreateModule {}
