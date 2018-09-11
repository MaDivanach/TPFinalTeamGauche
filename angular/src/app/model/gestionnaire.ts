import {User} from './user';
import {Role} from './role.enum';
import {Formation} from './formation';

export class Gestionnaire extends User {

  constructor(formations?: Formation[]) {
    super();
    this.role = Role.GESTIONNAIRE;
  }
}
