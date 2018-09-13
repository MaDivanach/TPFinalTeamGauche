import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../model/user';
import {Gestionnaire} from '../model/gestionnaire';
import {Technicien} from '../model/technicien';
import {Admin} from '../model/admin';
import {Formateur} from '../model/formateur';
import {Stagiaire} from '../model/stagiaire';
import {headersToString} from 'selenium-webdriver/http';
import {Role} from '../model/role.enum';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url: string = 'http://localhost:8080/Projet';
  header: HttpHeaders;

  constructor(private http: HttpClient) {
    this.header = new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic '});
  }

  public list(): Observable<User[]> {
    return this.http.get<User[]>(`${this.url}/rest/user`, {headers: this.header});
  }

  public listG(): Observable<Gestionnaire[]> {
    return this.http.get<Gestionnaire[]>(`${this.url}/rest/user/gestionnaire`, {headers: this.header});
  }

  public ListT(): Observable<Technicien[]> {
    return this.http.get<Technicien[]>(`${this.url}/rest/user/technicien`, {headers: this.header});
  }

  public listF(): Observable<Formateur[]> {
    return this.http.get<Formateur[]>(`${this.url}/rest/user/formateur`, {headers: this.header});
  }

  public listS(): Observable<Stagiaire[]> {
    return this.http.get<Stagiaire[]>(`${this.url}/rest/user/stagiaire`, {headers: this.header});
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/user/${id}`, {headers: this.header});
  }

  public findById(id: number): Observable<User> {
    return this.http.get<User>(`${this.url}/rest/user/${id}`, {headers: this.header});
  }

  public save(user: User): Observable<any> {
    if (user.id) {
      return this.http.put(`${this.url}/rest/user`, user, {headers: this.header});
    } else {
      if (user instanceof Gestionnaire) {
        const o: Gestionnaire = {
          type: user.type,
          id: user.id,
          username: user.username,
          password: btoa(user.password),
          nom: user.nom,
          prenom: user.prenom,
          telephone: user.telephone,
          role: user.role,
          adresse: user.adresse,
          formations: user.formations
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/user/gestionnaire`, o, {headers: this.header});
      } else if (user instanceof Technicien) {
        const o: Technicien = {
          type: user.type,
          id: user.id,
          nom: user.nom,
          prenom: user.prenom,
          username: user.username,
          password: btoa(user.password),
          telephone: user.telephone,
          role: user.role,
          adresse: user.adresse
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/user/technicien`, o, {headers: this.header});
      } else if (user instanceof Admin) {
        const o: Admin = {
          type: user.type,
          id: user.id,
          nom: user.nom,
          prenom: user.prenom,
          username: user.username,
          password: btoa(user.password),
          telephone: user.telephone,
          role: user.role,
          adresse: user.adresse
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/user/admin`, o, {headers: this.header});
      } else if (user instanceof Formateur) {
        const o: Formateur = {
          type: user.type,
          id: user.id,
          nom: user.nom,
          prenom: user.prenom,
          username: user.username,
          password: btoa(user.password),
          telephone: user.telephone,
          role: user.role,
          adresse: user.adresse,
          expertises: user.expertises,
          sessions: user.sessions

        };
        console.log(o);
        return this.http.post(`${this.url}/rest/user/formateur`, o, {headers: this.header});
      } else if (user instanceof Stagiaire) {
        const o: Stagiaire = {
          type: user.type,
          id: user.id,
          nom: user.nom,
          prenom: user.prenom,
          username: user.username,
          password: btoa(user.password),
          telephone: user.telephone,
          role: user.role,
          adresse: user.adresse,
          ordinateur: user.ordinateur,
          formation: user.formation
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/user/stagiaire`, o, {headers: this.header});
      }
    }
  }

  public loadByUsername(username: string): Observable<any> {
    return this.http.get(`${this.url}/rest/user/userload/${username}`, {headers: this.header});
  }
}
