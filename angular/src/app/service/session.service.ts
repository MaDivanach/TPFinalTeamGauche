import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Session} from '../model/session';
import {SessionPK} from '../model/session-pk';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  url: string = 'http://localhost:8080/Projet';
  headers: HttpHeaders;

  constructor(private http: HttpClient) {
    this.headers = new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic'});
  }

  public list(): Observable<Session[]> {
    return this.http.get<Session[]>(`${this.url}/rest/session/`, {headers: this.headers});
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/session/${id}`, {headers: this.headers});
  }

  public findById(id: number): Observable<Session> {
    return this.http.get<Session>(`${this.url}/rest/session/${id}`, {headers: this.headers});
  }

  public save(session: Session): Observable<any> {
    if (session.key) {
      return this.http.put(`${this.url}/rest/session/`, session, {headers: this.headers});
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
