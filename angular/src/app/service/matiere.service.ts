import { Injectable } from '@angular/core';
import {HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Matiere} from '../model/matiere';

@Injectable({
  providedIn: 'root'
})
export class MatiereService {

  url: string = 'http://localhost:8080/TPFinalTeamGauche';
  headers: HttpHeaders;

  constructor(private http: HttpMatiere) {

  }

  public list(): Observable<Matiere[]>{
    return this.http.get<Matiere[]>('${this.url}/rest/matiere/');
  }

}
