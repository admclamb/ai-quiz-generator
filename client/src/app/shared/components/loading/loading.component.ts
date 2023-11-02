import { Component } from '@angular/core';
import { LoadingService } from 'src/app/core/services/loading.service';

@Component({
  selector: 'app-loading',
  templateUrl: './loading.component.html',
})
export class LoadingComponent {
  constructor(public loadingService: LoadingService) {}
}
