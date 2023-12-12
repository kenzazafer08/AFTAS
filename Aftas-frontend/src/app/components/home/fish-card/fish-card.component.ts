import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-fish-card',
  templateUrl: './fish-card.component.html',
})
export class FishCardComponent {
  @Input() fish: any; 
}
