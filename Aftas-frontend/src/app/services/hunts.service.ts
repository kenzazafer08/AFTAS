import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { hunts } from '../types/hunts';

@Injectable({
  providedIn: 'root'
})
export class HuntsService {
  private apiUrl = 'http://localhost:8080/hunts';

  constructor(private httpClient : HttpClient) { }

  get(competitionCode : string | null , memberNumber : number ) : Observable<hunts[]>{
    const url = this.apiUrl + '/' + competitionCode + '/' + memberNumber
    return this.httpClient.get<hunts[]>(url);
  }
}
