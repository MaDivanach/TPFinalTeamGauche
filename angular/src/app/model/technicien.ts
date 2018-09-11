import {User} from './user';
import {Role} from './role.enum';

export class Technicien extends User {

  constructor() {
    super();
    this.role = Role.TECHNICIEN;
  }

}
