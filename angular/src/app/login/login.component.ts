import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {AuthService} from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  credentials = {username: '', password: ''};
  authStatus: boolean;
  credentialstest = {username: 'admin', password: 'admin'};

  ngOnInit() {
    this.authStatus = this.app.isAuth;
  }

  constructor(private app: AuthService, private http: HttpClient, private router: Router) {
  }

  onSignIn() {
    if ((this.credentials.username === this.credentialstest.username) && (this.credentials.password === this.credentialstest.password)) {
      this.app.signIn().then(
        () => {
          console.log('sign in successful');
          this.authStatus = this.app.isAuth;
          this.router.navigate(['home']);
        }
      );
    } else {
      alert('Mauvais identifiants');
    }
  }

  onSignOut() {
    this.app.signOut();
    this.authStatus = this.app.isAuth;
  }

  /*  login() {
      this.app.authenticate(this.credentials, () => {
        this.router.navigateByUrl('/user');
      });
      return false;
    }*/


}
