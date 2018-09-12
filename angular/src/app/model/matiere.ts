import {Niveau} from './niveau.enum';

export class Matiere {
  constructor(private _id?: number, private _titre?: string, private _objectif?: string, private _niveau?: Niveau) {

  }

  get id(): number {
    return this._id;
  }

  get titre(): string {
    return this._titre;
  }

  get objectif(): string {
    return this._objectif;
  }

  get niveau(): number {
    return this._niveau;
  }

  set id(value: number) {
    this._id = value;
  }

  set titre(value: string) {
    this._titre = value;
  }

  set objectif(value: string) {
    this._objectif = value;
  }

  set niveau(value: number) {
    this._niveau = value;
  }

}
