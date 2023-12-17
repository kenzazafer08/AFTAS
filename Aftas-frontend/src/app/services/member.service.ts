import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Member } from '../types/member';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MemberService {

  private apiUrl = 'http://localhost:8080/members';


  constructor(private httpClient : HttpClient) { }

  getMembers() : Observable<Member[]> {
    const url = this.apiUrl + '/list';
    return this.httpClient.get<Member[]>(url);
  }
}
