import {SessionPK} from './session-pk';

export class Session {
  constructor(
    private _key?: SessionPK,
    private _dateDebut?: Date,
    private _dateFin?: Date) {
  }

  get key(): SessionPK {
    return this._key;
  }

  set key(value: SessionPK) {
    this._key = value;
  }

  get dateDebut(): Date {
    return this._dateDebut;
  }

  set dateDebut(value: Date) {
    this._dateDebut = value;
  }

  get dateFin(): Date {
    return this._dateFin;
  }

  set dateFin(value: Date) {
    this._dateFin = value;
  }
}
