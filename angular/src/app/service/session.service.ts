import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Session} from '../model/session';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  url: string = 'http://localhost:8080/Projet';

  header: HttpHeaders;

  constructor(private http: HttpClient) {
    this.header = new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic '});
  }

  public list(): Observable<Session[]> {
    return this.http.get<Session[]>(`${this.url}/rest/session/`, {headers: this.header});
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/session/${id}`, {headers: this.header});
  }

  public findById(id: number): Observable<Session> {
    return this.http.get<Session>(`${this.url}/rest/session/${id}`, {headers: this.header});
  }

  public save(session: Session): Observable<any> {
    if (session.key) {
      return this.http.put(`${this.url}/rest/session/`, session, {headers: this.header});
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
