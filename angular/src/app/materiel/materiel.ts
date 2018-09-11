export class Materiel {
  constructor(private _coutUtilisation?: number) {

  }

  get coutUtilisation(): number{
    return this._coutUtilisation;
  }

  set coutUtilisation(value : number){
    this._coutUtilisation = value;
  }
}
