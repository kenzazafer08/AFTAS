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

  getCompetitions(pageNumber: number, pageSize: number) : Observable<Competition[]>{
    let listURL : string = `${this.apiUrl}/list?page=${pageNumber}&size=${pageSize}`;
    return this.httpClient.get<Competition[]>(listURL);
  }

  getTotalPagesNumber(pageSize : number) : Observable<number>{
    let pagesURL : string = `${this.apiUrl}/pages/${pageSize}`;
    return this.httpClient.get<number>(pagesURL);
  }
}
