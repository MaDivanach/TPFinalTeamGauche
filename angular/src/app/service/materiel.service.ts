import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Materiel} from '../materiel/materiel';
import {_mymateriel} from '../materiel/tableauMateriel';
import {Ordinateur} from '../materiel/ordinateur';
import {Salle} from '../materiel/salle';
import {VideoProjecteur} from '../materiel/videoProjecteur';

@Injectable({
  providedIn: 'root'
})
export class MaterielService {

  @Injectable({
    providedIn: 'root'
  })

  url: string = 'http://localhost:8080/';
  headers: HttpHeaders;

  constructor(private http :HttpClient) {
    this.headers = new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic ' + btoa('olivier:olivier')});
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
    if (_mymateriel.id) {
      return this.http.put(`${this.url}/rest/materiel/`, _mymateriel, {headers: this.header});
    } else {
      /* return this.http.post(`${this.url}/rest/adherent/`, adherent);*/
      if (_mymateriel instanceof Ordinateur) {
        const o = {
          id: _mymateriel.id, processeur: ordinateur.processeur, ram: ordinateur.ram, dd: ordinateur.dd, dateAchat: ordinateur.dateAchat
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/ordinateur/`, o);
      }
      else if (_mymateriel instanceof Salle) {
        const o = {
          id: _mymateriel.id, capacite: salle.capacite
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/salle/`, o);
      }
    }
  else
    {
      const o = {
        id: _mymateriel.id
      };
      console.log(o);
      return this.http.post(`${this.url}/rest/videoProjecteur/`, o);
    }
  }
}
