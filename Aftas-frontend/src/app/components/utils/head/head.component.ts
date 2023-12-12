import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-head',
  templateUrl: './head.component.html',
  styleUrls: ['./head.component.css']
})
export class HeadComponent implements OnInit{

  @Input() title:string | undefined;
  @Input() text:string | undefined;
  @Input() color:string | undefined;
  

  @Output() btnClick = new EventEmitter();

  constructor() {}
  ngOnInit(): void {
  }

  onClick(){
    this.btnClick.emit();
  }

}
