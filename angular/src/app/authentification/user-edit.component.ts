import {Component, OnInit} from '@angular/core';
import {User} from '../model/user';
import {UserService} from '../service/user.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Gestionnaire} from '../model/gestionnaire';
import {Admin} from '../model/admin';
import {Technicien} from '../model/technicien';
import {Stagiaire} from '../model/stagiaire';
import {Formateur} from '../model/formateur';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {

  user: User;

  constructor(private userService: UserService, private ar: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.ar.params.subscribe(params => {
      if (params.type === 'gestionnaire') {
        this.user = new Gestionnaire();
      } else if (params.type === 'admin') {
        this.user = new Admin();
      } else if (params.type === 'technicien') {
        this.user = new Technicien();
      } else if (params.type === 'stagiaire') {
        this.user = new Stagiaire();
      } else if (params.type === 'formateur') {
        this.user = new Formateur();
      } else {
        this.user = null;
      }
      if (params.id) {
        this.userService.findById(params.id).subscribe(
          resp => {
          this.user = resp;
        });
      }
    });
  }

  public save() {
    this.userService.save(this.user).subscribe(
      resp => {
      this.router.navigate(['/user']);
    });
  }
}
