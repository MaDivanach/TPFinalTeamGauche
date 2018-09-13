export class Materiel {
  constructor(
    private _id?: number,
    private _coutUtilisation?: number,
    private _type?: string
  ) {
  }

  get type(): string {
    return this._type;
  }

  set type(value: string) {
    this._type = value;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get coutUtilisation(): number {
    return this._coutUtilisation;
  }

  set coutUtilisation(value: number) {
    this._coutUtilisation = value;
  }
}
