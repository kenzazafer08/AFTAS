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
  filteredCompetitions : Competition[] = [];

  constructor(private _competitionsService : CompetitionService){}

  ngOnInit(): void {
    this._competitionsService.getCompetitions().subscribe(competitions => this.competitions = competitions ).add(() => this.filteredCompetitions = this.competitions);
    console.log(this.competitions + ' filtered')
  }
  onFilterChange(event: Event): void {
    const currentDate = new Date();
    currentDate.setHours(0, 0, 0, 0);
    console.log(currentDate)
    const selectedFilter = (event.target as HTMLSelectElement)?.value;
    if (selectedFilter === 'pending') {
      this.filteredCompetitions = this.competitions.filter(competition => {
        const competitionDate = new Date(competition.date);
        competitionDate.setHours(0, 0, 0, 0);
        return competitionDate > currentDate;
      });
    } else if (selectedFilter === 'in_progress') {
      this.filteredCompetitions = this.competitions.filter(competition => {
        const competitionDate = new Date(competition.date);
        return competitionDate.toDateString() === currentDate.toDateString();
      });
    } else if (selectedFilter === 'closed') {
      this.filteredCompetitions = this.competitions.filter(competition => {
        const competitionDate = new Date(competition.date);
        competitionDate.setHours(0, 0, 0, 0);
        return competitionDate < currentDate;
      });
    } else {
      this.filteredCompetitions = this.competitions;
    }
  }
}

