import {Component, OnInit} from '@angular/core';
import {AuthService} from '../service/auth.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {


  title = 'Accueil';
  greeting = {};

  constructor(private app: AuthService, private http: HttpClient) {
    http.get('').subscribe(data => this.greeting = data);
  }

  authenticated() {
    return this.app.signIn();
  }

}
