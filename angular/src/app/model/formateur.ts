import {User} from './user';
import {Role} from './role.enum';
import {Session} from './session';
import {Expertise} from './expertise';

export class Formateur extends User {


  constructor(private _sessions: Session[], private _expertises: Expertise[]) {
    super();
    this.role = Role.FORMATEUR;
  }


  get sessions(): Session[] {
    return this._sessions;
  }

  set sessions(value: Session[]) {
    this._sessions = value;
  }


  get expertises(): Expertise[] {
    return this._expertises;
  }

  set expertises(value: Expertise[]) {
    this._expertises = value;
  }
}
