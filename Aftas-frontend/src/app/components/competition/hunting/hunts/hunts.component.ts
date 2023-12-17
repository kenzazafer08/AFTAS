import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HuntsService } from 'src/app/services/hunts.service';
import { hunts } from 'src/app/types/hunts';

@Component({
  selector: 'app-hunts',
  templateUrl: './hunts.component.html',
  styleUrls: ['./hunts.component.css']
})
export class HuntsComponent implements OnInit {
  id: string | undefined = undefined;
  num: number = 0;
  hunts : hunts[] | undefined;
  constructor (private route: ActivatedRoute , private huntService : HuntsService){}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['code']; 
      this.num = params['num'];
    });  
    this.huntService.get(this.id, this.num).subscribe(res => this.hunts = res);}
  }

