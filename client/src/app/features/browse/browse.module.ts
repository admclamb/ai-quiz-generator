import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowseComponent } from './browse.component';
import { SharedModule } from '@app/shared';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [BrowseComponent],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild([{ path: '', component: BrowseComponent }]),
  ],
})
export class BrowseModule {}
