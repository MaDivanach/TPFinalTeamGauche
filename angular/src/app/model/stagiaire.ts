import {User} from './user';
import {Role} from './role.enum';
import {Ordinateur} from './ordinateur';
import {Formation} from './formation';


export class Stagiaire extends User {

  constructor(private _ordinateur?: Ordinateur, private _formation?: Formation) {
    super();
    this.role = Role.STAGIAIRE;
    this.type = 'stagiaire';
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
