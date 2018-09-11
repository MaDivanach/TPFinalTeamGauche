import {Matiere} from './matiere';
import {Formateur} from './formateur';
import {Formation} from './Formation';

export class SessionPK {
  constructor(
    private _matiere?: Matiere,
    private _formateur?: Formateur,
    private _formation?: Formation) {
  }

  get matiere(): Matiere {
    return this._matiere;
  }

  set matiere(value: Matiere) {
    this._matiere = value;
  }

  get formateur(): Formateur {
    return this._formateur;
  }

  set formateur(value: Formateur) {
    this._formateur = value;
  }

  get formation(): Formation {
    return this._formation;
  }

  set formation(value: Formation) {
    this._formation = value;
  }

}
