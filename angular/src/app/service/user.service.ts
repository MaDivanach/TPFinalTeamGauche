import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../model/user';
import {Gestionnaire} from '../model/gestionnaire';
import {Technicien} from '../model/technicien';
import {Admin} from '../model/admin';
import {Formateur} from '../model/formateur';
import {Stagiaire} from '../model/stagiaire';

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
    return this.http.get<User[]>(`${this.url}/rest/user/`, {headers: this.header});
  }

  public listG(): Observable<Gestionnaire[]> {
    return this.http.get<Gestionnaire[]>(`${this.url}/rest/gestionnaire/`, {headers: this.header});
  }

  public ListT(): Observable<Technicien[]> {
    return this.http.get<Technicien[]>(`${this.url}/rest/technicien/`, {headers: this.header});
  }

  public listF(): Observable<Formateur[]> {
    return this.http.get<Formateur[]>(`${this.url}/rest/formateur/`, {headers: this.header});
  }

  public listS(): Observable<Stagiaire[]> {
    return this.http.get<Stagiaire[]>(`${this.url}/rest/stagiaire/`, {headers: this.header});
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/user/${id}`, {headers: this.header});
  }

  public findById(id: number): Observable<User> {
    return this.http.get<User>(`${this.url}/rest/user/${id}`, {headers: this.header});
  }

  public save(user: User): Observable<any> {
    if (user.id) {
      return this.http.put(`${this.url}/rest/user/`, user, {headers: this.header});
    } else {
      if (user instanceof Gestionnaire) {
        const o = {
          id: user.id,
          nom: user.nom,
          prenom: user.prenom,
          username: user.username,
          password: user.password,
          telephone: user.telephone,
          role: user.role,
          formations: user.formations
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/gestionnaire/`, o, {headers: this.header});
      } else if (user instanceof Technicien) {
        const o = {
          id: user.id,
          nom: user.nom,
          prenom: user.prenom,
          username: user.username,
          password: user.password,
          telephone: user.telephone,
          role: user.role
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/technicien/`, o, {headers: this.header});
      } else if (user instanceof Admin) {
        const o = {
          id: user.id,
          nom: user.nom,
          prenom: user.prenom,
          username: user.username,
          password: user.password,
          telephone: user.telephone,
          role: user.role
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/admin/`, o, {headers: this.header});
      } else if (user instanceof Formateur) {
        const o = {
          id: user.id,
          nom: user.nom,
          prenom: user.prenom,
          username: user.username,
          password: user.password,
          telephone: user.telephone,
          role: user.role,
          expertises: user.expertises,
          sessions: user.sessions

        };
        console.log(o);
        return this.http.post(`${this.url}/rest/formateur/`, o, {headers: this.header});
      } else if (user instanceof Stagiaire) {
        const o = {
          id: user.id,
          nom: user.nom,
          prenom: user.prenom,
          username: user.username,
          password: user.password,
          telephone: user.telephone,
          role: user.role,
          ordinateur: user.ordinateur,
          formation: user.formation
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/stagiaire/`, o, {headers: this.header});
      }
    }
  }
}
