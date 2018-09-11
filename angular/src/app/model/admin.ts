import {User} from './user';
import {Role} from './role.enum';

export class Admin extends User {

  constructor() {
    super();
    this.role = Role.ADMIN;
  }

}
