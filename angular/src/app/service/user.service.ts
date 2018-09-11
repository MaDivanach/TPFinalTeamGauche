import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../model/user';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url: string = 'http://localhost:8080/Projet';

  constructor(private http: HttpClient) {
  }

  public list(): Observable<User[]> {
    return this.http.get<User[]>(`${this.url}/rest/user/`);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/user/${id}`);
  }

  public findById(id: number): Observable<User> {
    return this.http.get<User>(`${this.url}/rest/user/${id}`);
  }

  public save(user: User): Observable<any> {
    if (user.id) {
      return this.http.put(`${this.url}/rest/user/`, user);
    } else {
      if (user instanceof stagiaire) {
        const o = {
          id: user.id, nom: user.nom, prenom: user.prenom, username: user.username, password: user.password, telephone: user.telephone, ordinateur: user.
        };
        return this.http.post(`${this.url}/rest/user/`, o);
      }
    }


  }

}
