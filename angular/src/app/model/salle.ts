import {Formation} from './Formation';
import {Materiel} from './materiel';

export class Salle extends Materiel {

  constructor(private _capacite?: number, private _formationsSalle?: Formation[]){
    super();
  }


  get formationsSalle(): Formation[] {
    return this._formationsSalle;
  }

  set formationsSalle(value: Formation[]) {
    this._formationsSalle = value;
  }

  get capacite(): number {
    return this._capacite;
  }

  set capacite(value: number) {
    this._capacite = value;
  }
}
