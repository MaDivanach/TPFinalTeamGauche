import {User} from './user';
import {Role} from './role.enum';
import {Formation} from './formation';
import {Ordinateur} from './ordinateur';

export class Stagiaire extends User {

  constructor(private _ordinateur?: Ordinateur, private _formation?: Formation) {
    super();
    this.role = Role.STAGIAIRE;
  }


  get ordinateur(): Ordinateur {
    return this._ordinateur;
  }

  set ordinateur(value: Ordinateur) {
    this._ordinateur = value;
  }

  get formation(): Formation {
    return this._formation;
  }

  set formation(value: Formation) {
    this._formation = value;
  }
}
