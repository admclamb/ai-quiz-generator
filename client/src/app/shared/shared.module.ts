import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { COMPONENTS } from './components';
import { NavbarComponent } from './components/navbar/navbar.component';

@NgModule({
  declarations: [...COMPONENTS, NavbarComponent],
  imports: [CommonModule],
})
export class SharedModule {}
