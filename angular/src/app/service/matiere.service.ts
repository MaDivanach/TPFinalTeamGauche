import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Matiere} from '../model/matiere';
import {Materiel} from '../model/materiel';

@Injectable({
  providedIn: 'root'
})
export class MatiereService {

  url: string = 'http://localhost:8080/Projet';

  header: HttpHeaders;

  constructor(private http: HttpClient) {
    this.header = new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic '});
  }


  public list(): Observable<Matiere[]> {
    return this.http.get<Matiere[]>(`${this.url}/rest/matiere/`, {headers: this.header});
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/matiere/${id}`, {headers: this.header});
  }

  public findById(id: number): Observable<Matiere> {
    return this.http.get<Matiere>(`${this.url}/rest/matiere/${id}`, {headers: this.header});
  }

  public save(matiere: Matiere): Observable<any> {
    if (matiere.id) {
      return this.http.put(`${this.url}/rest/matiere/`, matiere, {headers: this.header});
    } else {
      const o = {
        id: matiere.id,
        titre: matiere.titre,
        objectif: matiere.objectif,
        niveau: matiere.niveau,
      };
      console.log(o);
      return this.http.post(`${this.url}/rest/matiere`, o, {headers: this.header});
    }
  }

}
