import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ranking } from '../types/ranking';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RankingService {
  private apiUrl = 'http://localhost:8080/rankings';

  constructor(private httpClient : HttpClient) { }
  getMembers(code : string | null): Observable<Ranking[]>{
    const url : string = `${this.apiUrl}/Competition/${code}`;
    return this.httpClient.get<Ranking[]>(url);
  }
}
