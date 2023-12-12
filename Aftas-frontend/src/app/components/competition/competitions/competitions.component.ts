import { Component, OnInit } from '@angular/core';
import { CompetitionService } from 'src/app/services/competition.service';
import { Competition } from 'src/app/types/competition';

@Component({
  selector: 'app-competitions',
  templateUrl: './competitions.component.html',
  styleUrls: ['./competitions.component.css']
})
export class CompetitionsComponent implements OnInit{
  competitions : Competition[] = [];

  constructor(private _competitionsService : CompetitionService){}

  ngOnInit(): void {
    this._competitionsService.getCompetitions().subscribe(competitions => this.competitions = competitions);
    console.log(this.competitions)
  }

}
