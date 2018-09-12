import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Session} from '../model/session';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  url: string = 'http://localhost:8080/Projet';

  /*headers: HttpHeaders; */

  constructor(private http: HttpClient) {
  }

  public list(): Observable<Session[]> {
    return this.http.get<Session[]>(`${this.url}/rest/session/`);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/session/${id}`);
  }

  public findById(id: number): Observable<Session> {
    return this.http.get<Session>(`${this.url}/rest/session/${id}`);
  }

  public save(session: Session): Observable<any> {
    if (session.key) {
      return this.http.put(`${this.url}/rest/session/`, session);
    } else {
      const o = {
        key: session.key,
        dateDebut: session.dateDebut,
        dateFin: session.dateFin,
      };
      console.log(o);
      return this.http.post(`${this.url}/rest/session`, o);
    }
  }

}
