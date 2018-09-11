import {User} from './user';
import {Role} from './role.enum';

export class Formateur extends User {

  constructor(private sessions:Session[], expertises:Expertise[]) {
    super();
    this.role = Role.FORMATEUR;
  }
}
