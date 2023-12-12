import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Competition } from '../types/competition';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompetitionService {

  private apiUrl = 'http://localhost:8080/competitions';

  constructor(private httpClient : HttpClient) { }

  getCompetitions() : Observable<Competition[]>{
    let listURL : string = `${this.apiUrl}/list`;
    return this.httpClient.get<Competition[]>(listURL);
  }
}
