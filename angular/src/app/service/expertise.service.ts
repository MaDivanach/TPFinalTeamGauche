import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Expertise} from '../model/expertise';
import {Observable} from 'rxjs';
import {Session} from '../model/session';

@Injectable({
  providedIn: 'root'
})
export class ExpertiseService {

  url: string = 'http://localhost:8080/Projet';

  /*headers: HttpHeaders;*/

  constructor(private http: HttpClient) {
  }

  public list(): Observable<Expertise[]> {
    return this.http.get<Expertise[]>(`${this.url}/rest/expertise/`);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/expertise/${id}`);
  }

  public findById(id: number): Observable<Expertise> {
    return this.http.get<Expertise>(`${this.url}/rest/expertise/${id}`);
  }

  public save(expertise: Expertise): Observable<any> {
    if (expertise.key) {
      return this.http.put(`${this.url}/rest/expertise/`, expertise);
    } else {
      const o = {
        dateDebut: session.dateDebut,
        dateFin: session.dateFin,
      };
      console.log(o);
      return this.http.post(`${this.url}/rest/expertise`, o);
    }
  }
  
}
