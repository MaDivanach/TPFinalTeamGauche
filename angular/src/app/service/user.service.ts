import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url: string = 'http://localhost:8080/Projet';

  constructor(private http: HttpClient) {
  }

  public list(): Observable
}
