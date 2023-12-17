import { Component, EventEmitter, Input, Output } from '@angular/core';
import { faBoxOpen, faTrash } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent {
  @Input() columns: any[] = [];
  @Input() data: any[] = [];
  @Input() open : boolean = false;
  @Input() remove : boolean = false;

  @Output() Open = new EventEmitter();
  @Output() Delete = new EventEmitter();
  @Output() plus = new EventEmitter();
  @Output() minus = new EventEmitter();


  faDelete = faTrash;
  faDetails = faBoxOpen;

  isNumber(value: any): boolean {
    return typeof value === 'number';
  }

  incrementValue(item: any, field: string): void {
    if (this.isNumber(item[field])) {
      item[field]++;
      this.plus.emit(item);
    }
  }

  decrementValue(item: any, field: string): void {
    if (this.isNumber(item[field]) && item[field] > 1) {
      item[field]--;
      this.minus.emit(item);
    }
  }

  isObjectColumn(column: any): boolean {
    return typeof column.field === 'string' && column.field.includes('.');
  }

  getItemValue(item: any, column: any): any {
    const fieldHierarchy = column.field.split('.');
    let value = item;

    for (const field of fieldHierarchy) {
        if (value && value[field] !== undefined) {
            value = value[field];
        } else {
            return 'Value not available';
        }
    }

    return value;
}


  onDelete(item : any){
    this.Delete.emit(item);
  }
  openHunts(item : any){
    this.Open.emit(item);
  }

}
