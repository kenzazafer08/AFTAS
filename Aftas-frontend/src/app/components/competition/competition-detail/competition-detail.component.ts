import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CompetitionService } from 'src/app/services/competition.service';
import { CompetitionCardComponent } from '../competition-card/competition-card.component';
import { Competition } from 'src/app/types/competition';
import { Ranking } from 'src/app/types/ranking';
import { RankingService } from 'src/app/services/ranking.service';

@Component({
  selector: 'app-competition-detail',
  templateUrl: './competition-detail.component.html',
  styleUrls: ['./competition-detail.component.css']
})
export class CompetitionDetailComponent implements OnInit {
  id: string | null = null;
  competition : Competition | undefined = undefined;
  rankings : Ranking[] =  [];

  tableColumns = [
    { header: 'Number', field: 'member.num' },
    { header: 'Name', field: 'member.num' },
    { header: 'Family name', field: 'member.familyName' },
    { header: 'Nationality', field: 'member.nationality' },
    { header: 'Accession date', field : 'member.accessionDate'},
    { header : 'Identity document', field : 'member.identityDocument'},
    { header : 'Identity number', field : 'member.identityNumber'},
    { header : 'Rank', field : 'rank'},
    { header : 'Score', field : 'score'},
  ];

 constructor (private route: ActivatedRoute , private competitionService : CompetitionService, private rankingService : RankingService){}
ngOnInit(): void {
  this.route.params.subscribe(params => {
    this.id = params['code']; 
  });  
  this.competitionService.getCompetition(this.id).subscribe(competition => this.competition = competition).add(console.log(this.competition));
  this.rankingService.getMembers(this.id).subscribe(members => this.rankings = members).add(console.log(this.rankings));
}

}
