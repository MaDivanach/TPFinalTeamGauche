import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Expertise} from '../model/expertise';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExpertiseService {

  url: string = 'http://localhost:4200/Projet';
  headers: HttpHeaders;

  constructor(private http: HttpClient) {
  }

  public list(): Observable<Expertise[]> {
    return this.http.get<Expertise[]>('${this.url}/rest/expertise/');
  }

  public delete(id: number): Observable<any> {
    return this.http.delete('${this.url}/rest/expertise/${id}');
  }

  public findById(id: number): Observable<Expertise> {
    return this.http.get<Expertise>(`${this.url}/rest/expertise/${id}`);
  }

}
