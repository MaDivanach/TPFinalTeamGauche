import {User} from './user';
import {Role} from './role.enum';
import {Session} from './session';
import {Expertise} from './expertise';

export class Formateur extends User {

  constructor(private sessions?: Session[], expertises?: Expertise[]) {
    super();
    this.role = Role.FORMATEUR;
  }
}
