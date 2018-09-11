import {User} from './user';
import {Role} from './role.enum';

export class Gestionnaire extends User {
  constructor() {
    super();
    this.role = Role.GESTIONNAIRE;
  }
}
