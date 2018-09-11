import {User} from './user';
import {Role} from './role.enum';

export class Stagiaire extends User {

  constructor() {

    super();
    this.role = Role.STAGIAIRE;
  }

}
