import {Component, OnInit} from '@angular/core';
import {User} from '../model/user';
import {UserService} from '../service/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.list();
  }

  public list() {
    this.userService.list().subscribe(
      resp => {
        this.users = resp;
        for (const user of this.users) {
          user.password = atob(user.password);
        }
      }
    );
  }

  public delete(id: number) {
    return this.userService.delete(id).subscribe(
      resp => {
        this.list();
      }
    );
  }


}
