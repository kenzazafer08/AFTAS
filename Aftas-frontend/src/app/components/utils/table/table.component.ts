import { Component, EventEmitter, Input, Output } from '@angular/core';
import { faEdit, faTrash, faPlusCircle, faBoxOpen } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent {
  @Input() columns: any[] = [];
  @Input() data: any[] = [];
  @Input() question : boolean = false;

  @Output() Delete = new EventEmitter();
  @Output() Assign = new EventEmitter();
  @Output() btnClick = new EventEmitter();


  faDelete = faTrash;
  faEdit = faEdit;
  faPlus = faPlusCircle;
  faOpen = faBoxOpen;

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

  onAddAnswer(item : any){
    this.Assign.emit(item);
  }

  onClick(item : any){
    this.btnClick.emit(item);
  }

}
