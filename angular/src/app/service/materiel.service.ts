import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Materiel} from '../model/materiel';
import {Ordinateur} from '../model/ordinateur';
import {Salle} from '../model/salle';
import {VideoProjecteur} from '../model/videoProjecteur';

@Injectable({
  providedIn: 'root'
})
export class MaterielService {

  url: string = 'http://localhost:8080/Projet';
  header: HttpHeaders;

  constructor(private http: HttpClient) {
    this.header = new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic'});
  }

  public list(): Observable<Materiel[]> {
    return this.http.get<Materiel[]>(`${this.url}/rest/materiel/`, {headers: this.header});
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/materiel/${id}`, {headers: this.header});
  }

  public findById(id: number): Observable<Materiel> {
    return this.http.get<Materiel>(`${this.url}/rest/materiel/${id}`, {headers: this.header});
  }

  public save(materiel: Materiel): Observable<any> {
    if (materiel.id) {
      if (materiel instanceof Ordinateur) {
        return this.http.put(`${this.url}/rest/materiel/ordinateur`, materiel, {headers: this.header});
      } else if (materiel instanceof Salle) {
        return this.http.put(`${this.url}/rest/materiel/salle`, materiel, {headers: this.header});
      } else if (materiel instanceof VideoProjecteur) {
        return this.http.put(`${this.url}/rest/materiel/videoprojecteur`, materiel, {headers: this.header});
      }
    } else {
      if (materiel instanceof Ordinateur) {
        const o = {
          id: materiel.id,
          type: materiel.type,
          coutUtilisation: materiel.coutUtilisation,
          processeur: materiel.processeur,
          ram: materiel.ram,
          dd: materiel.dd,
          dateAchat: materiel.dateAchat
        };
        return this.http.post(`${this.url}/rest/materiel/ordinateur`, o, {headers: this.header});
      } else if (materiel instanceof Salle) {
        const o = {
          id: materiel.id,
          coutUtilisation: materiel.coutUtilisation,
          capacite: materiel.capacite
        };
        return this.http.post(`${this.url}/rest/materiel/salle`, o, {headers: this.header});
      } else if (materiel instanceof VideoProjecteur) {
        const o = {
          id: materiel.id,
          coutUtilisation: materiel.coutUtilisation
        };
        return this.http.post(`${this.url}/rest/materiel/videoprojecteur`, o, {headers: this.header});
      }
    }
  }
}
