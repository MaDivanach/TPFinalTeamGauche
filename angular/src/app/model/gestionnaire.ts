import {User} from './user';
import {Role} from './role.enum';
import {Formation} from './formation';

export class Gestionnaire extends User {

  constructor(private _formations?: Formation[]) {
    super();
    this.role = Role.GESTIONNAIRE;
    this.type = 'gestionnaire';
  }


  get formations(): Formation[] {
    return this._formations;
  }

  set formations(value: Formation[]) {
    this._formations = value;
  }
}
