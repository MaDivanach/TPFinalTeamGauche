import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Materiel} from '../model/materiel';
import {_mymateriel} from '../materiel/tableauMateriel';
import {Ordinateur} from '../model/ordinateur';
import {Salle} from '../model/salle';
import {VideoProjecteur} from '../model/videoProjecteur';
import {instantiateDefaultStyleNormalizer} from '@angular/platform-browser/animations/src/providers';

@Injectable({
  providedIn: 'root'
})
export class MaterielService {

  url: string = 'http://localhost:8080/';
  header: HttpHeaders;

  constructor(private http: HttpClient) {
    this.header = new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic ' + btoa('olivier:olivier')});
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
      return this.http.put(`${this.url}/rest/materiel/`, materiel, {headers: this.header});
    } else {
      /* return this.http.post(`${this.url}/rest/adherent/`, adherent);*/
      if (materiel instanceof Ordinateur) {
        const o = {
          id: materiel.id, processeur: ordinateur.processeur, ram: ordinateur.ram, dd: ordinateur.dd, dateAchat: ordinateur.dateAchat
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/ordinateur/`, o);
      }
      else if (materiel instanceof Salle) {
        const o = {
          id: materiel.id, capacite: salle.capacite
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/salle/`, o);
      }
      else if (materiel instanceof VideoProjecteur) {
        const o = {
          id: materiel.id
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/videoProjecteur/`, o);
      }
    }
  }
}
