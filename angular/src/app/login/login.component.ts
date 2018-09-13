import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {AuthService} from '../service/auth.service';
import {UserDetails} from '../model/user-details';
import {UserService} from '../service/user.service';
import {Role} from '../model/role.enum';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  credentials = {username: '', password: ''};
  authStatus: boolean;
  credentialstest = {username: 'admin', password: 'admin'};
  userDetails: UserDetails;


  ngOnInit() {
    this.authStatus = this.app.isAuth;
  }

  constructor(private app: AuthService, private http: HttpClient, private router: Router, private userservice: UserService) {
  }

  onSignIn() {
    /*    console.log(this.userDetails.user.username);
        console.log(atob(this.userDetails.user.password));*/
    this.userservice.loadByUsername(this.credentials.username).subscribe(
      resp => {
        this.userDetails = resp;
        console.log(this.userDetails.user.username);
        console.log(this.userDetails.user.password);
        console.log(this.userDetails.user.role);
        console.log(this.userDetails.user.type);
        if ((this.credentials.username === this.userDetails.user.username)
          && (this.credentials.password === atob(this.userDetails.user.password))
          && (this.userDetails.user.type === 'admin')
        ) {
          console.log('on est rentré');
          this.app.signIn().then(
            () => {
              console.log('sign in successful');
              this.authStatus = this.app.isAuth;
              this.router.navigate(['home']);
            });
        } else {
          alert('Mauvais identifiants');
        }
      }, error => {
        alert('Mauvais identifiants');
      }
    );
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
