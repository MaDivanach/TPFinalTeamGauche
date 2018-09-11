import {User} from './user';
import {Role} from './role.enum';

export class Formateur extends User {

  constructor() {
    super();
    this.role = Role.FORMATEUR;
  }
}
