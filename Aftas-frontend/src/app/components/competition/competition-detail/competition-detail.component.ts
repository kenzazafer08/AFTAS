import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CompetitionService } from 'src/app/services/competition.service';
import { Competition } from 'src/app/types/competition';
import { Ranking } from 'src/app/types/ranking';
import { RankingService } from 'src/app/services/ranking.service';
import { MemberService } from 'src/app/services/member.service';
import { RankingReq } from 'src/app/types/rankingReq';
import { MemberReq } from 'src/app/types/MemberReq';
import Swal from 'sweetalert2';
const currentDate = new Date();
const DayAfter = new Date(currentDate);
DayAfter.setHours(0, 0, 0, 0)
@Component({
  selector: 'app-competition-detail',
  templateUrl: './competition-detail.component.html',
  styleUrls: ['./competition-detail.component.css']
})
export class CompetitionDetailComponent implements OnInit {
  id: string | null = null;
  competition : Competition | undefined = undefined;
  rankings : Ranking[] =  [];
  modal : boolean = false;
  text : string = "participant";
  waiting : boolean = false;
  in_progress : boolean = false;
  tableColumns = [
    { header: 'Number', field: 'member.num' },
    { header: 'Name', field: 'member.num' },
    { header: 'Family name', field: 'member.familyName' },
    { header: 'Nationality', field: 'member.nationality' },
    { header : 'Identity document', field : 'member.identityDocument'},
    { header : 'Identity number', field : 'member.identityNumber'},
    { header : 'Rank', field : 'rank'},
    { header : 'Score', field : 'score'},
  ];
  selectedMember : Ranking | undefined;
  modalDelete : boolean = false;
 constructor (private r : Router,private route: ActivatedRoute , private competitionService : CompetitionService, private rankingService : RankingService, private memberService : MemberService){}
ngOnInit(): void {
  this.route.params.subscribe(params => {
    this.id = params['code']; 
  });  
  this.competitionService.getCompetition(this.id).subscribe((competition) => {this.competition = competition ;
  const competitionDate = new Date(this.competition.date);
  competitionDate.setHours(0,0,0,0)
  this.waiting = competitionDate > DayAfter;
  this.in_progress = competitionDate.toDateString() === DayAfter.toDateString();
  console.log(this.in_progress, competitionDate , DayAfter);
  }).add(console.log(this.competition));
  this.rankingService.getMembers(this.id).subscribe(members => this.rankings = members).add(console.log(this.rankings));
  
}

OpenModal(){
  this.modal = true;
}

onFormSubmit(formData: any): void {
  if (formData) {
    const newRanking: RankingReq = {
      competition : this.competition?.code,
      member : formData.num,
      rank : null,
      score : null,
    };

    if (newRanking) {
      console.log(newRanking)
      this.rankingService.Add(newRanking).subscribe(r => this.rankings.push(r));
    }

    formData.member = "";
  }
}

  addMember(member : MemberReq) {
    this.modal = false;
    this.memberService.add(member).subscribe(member => 
      Swal.fire({
      title: 'Success!',
      text: `Member ${member.name} registered successfully !`,
      icon: 'success',
      confirmButtonText: 'Okay',
      confirmButtonColor: 'blue' // Change this to your desired color
    }).then((result) => {
      if (result.isConfirmed) {
      }
    }))
  }

  deleteModel(ranking : Ranking){
    this.modalDelete = true;
    this.selectedMember = ranking
  }

  delete(ranking : Ranking | undefined){
    this.modalDelete = false;
    if(ranking)
    this.rankingService.Delete(ranking.competition?.code , ranking.member.num).subscribe(ranking => Swal.fire({
      title: 'Success!',
      text: `Member ${ranking.member.name} removed successfully !`,
      icon: 'success',
      confirmButtonText: 'Okay',
      confirmButtonColor: 'blue' // Change this to your desired color
    }).then((result) => {
      if (result.isConfirmed) {
        this.rankingService.getMembers(this.id).subscribe(members => this.rankings = members).add(console.log(this.rankings));
      }
    }))
  }
  OpenHunt(ranking : Ranking | undefined){
    this.r.navigate(['/Competition/' , ranking?.competition?.code , ranking?.member.num])
  }
}


