import {Formateur} from './formateur';
import {Matiere} from './matiere';

export class ExpertisePK {
  constructor(
    private _matiere?: Matiere,
    private _formateur?: Formateur) {
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
}
