import {User} from './user';
import {Role} from './role.enum';

export class UserDetails {

  constructor(private _user: User, private _role?: Role) {

  }

  get password(): string {
    return this._user.password;
  }

  get username(): string {
    return this._user.username;
  }

  get user(): User {
    return this._user;
  }

  set user(value: User) {
    this._user = value;
  }

  get role(): Role {
    return this._role;
  }

  set role(value: Role) {
    this._role = value;
  }
}


