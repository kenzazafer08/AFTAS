import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CompetitionService } from 'src/app/services/competition.service';
import { HuntsService } from 'src/app/services/hunts.service';
import { MemberService } from 'src/app/services/member.service';
import { Competition } from 'src/app/types/competition';
import { hunts } from 'src/app/types/hunts';
import { Member } from 'src/app/types/member';

@Component({
  selector: 'app-hunts',
  templateUrl: './hunts.component.html',
  styleUrls: ['./hunts.component.css']
})
export class HuntsComponent implements OnInit {
  id: string | null = null;
  num: number = 0;
  hunts : hunts[] = [];
  competition : Competition | undefined = undefined;
  member : Member | undefined = undefined;
  tableColumns = [
    { header: 'Fish', field: 'fish.name' },
    { header: 'Number of fishes', field: 'numberOfFishes' },
  ];
  constructor (private route: ActivatedRoute , private huntService : HuntsService , private competitionService : CompetitionService , private memberService : MemberService){}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['code']; 
      this.num = params['num'];
    });  
    this.huntService.get(this.id, this.num).subscribe(res => this.hunts = res);
    this.competitionService.getCompetition(this.id).subscribe(res => this.competition = res);
    this.memberService.get(this.num).subscribe(res => this.member = res);
  }
  }

