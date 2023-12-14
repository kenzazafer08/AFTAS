import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Competition } from 'src/app/types/competition';

@Component({
  selector: 'app-add-competition',
  templateUrl: './add-competition.component.html',
  styleUrls: ['./add-competition.component.css']
})
export class AddCompetitionComponent implements OnInit{
  ngOnInit(): void {
  }
  text : string = 'Competition';
  yourEntityFields: any[] = [
    { type: 'date', label: 'Competition Date', name: 'dateField', inputType: 'date' },
    { type: 'text', label: 'Competition location', name: 'location', inputType: 'text' },
    { type: 'time', label: 'Start Time', name: 'startTime', inputType: 'time' },
    { type : 'time', label: 'End Time', name: 'endTime', inputType: 'time' },
    { name: 'numberOfParticipants', label: 'Number of participant', type: 'number', inputType: 'number' , minValue : 1 , maxValue: 10},
    { name: 'amount', label: 'Playing amount', type: 'number', inputType: 'number' , minValue : 0 },
  ];

  @Output() onAddCompetition : EventEmitter<Competition> = new EventEmitter();

}
