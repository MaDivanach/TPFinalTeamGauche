import {Injectable} from "@angular/core";
import {Formation} from "../model/formation";

@Injectable({
  providedIn: 'root'
})
export class FormationService {

  url: string = 'http://localhost:8080/demo';
  header: HttpHeaders;

  constructor(private http: HttpClient) {
    this.header = new HttpHeaders({
      'Content-type': 'application/json',
      'Authorization': 'Basic ' + btoa('olivier:olivier')
    });
  }

  public list(): Observable<Formation[]> {
    return this.http.get<Formation[]>(`${this.url}/rest/formation/`, {headers: this.header});
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/formation/${id}`, {headers: this.header});
  }

  public findById(id: number): Observable<Formation> {
    return this.http.get<Formation>(`${this.url}/rest/formation/${id}`, {headers: this.header});
  }

  public save(formation: Formation): Observable<any> {
    if (formation.id) {
      return this.http.put(`${this.url}/rest/formation/`, formation, {headers: this.header});
    } else {
      const o = {
        id: formation.id,
        nom: formation.nom,
        dateDebut: formation.dateDebut,
        dateFin: formation.dateFin,
        gestionnaire: formation.gestionnaire,
        videoProjecteur : formation.videoProjecteur,
        salle: formation.salle,
        stagiaires: formation.stagiaires,
        sessions: formation.sessions
      };
      console.log(o);
      return this.http.post(`${this.url}/rest/formation/`, o, {headers: this.header});
    }
  }
}
