export class Salle {

  constructor(private _capacite: number){}


  get capacite(): number {
    return this._capacite;
  }

  set capacite(value: number) {
    this._capacite = value;
  }
}
