import {Stagiaire} from './stagiaire';
import {Materiel} from './materiel';

export class Ordinateur extends Materiel {

  constructor(private _processeur?: string, private  _ram?: string, private _dd?: string, private _dateAchat?: Date, private _stagiaires?: Stagiaire[]) {
    super();
    this.type = 'ordinateur';
  }


  get stagiaires(): Stagiaire[] {
    return this._stagiaires;
  }

  set stagiaires(value: Stagiaire[]) {
    this._stagiaires = value;
  }

  get processeur(): string {
    return this._processeur;
  }

  set processeur(value: string) {
    this._processeur = value;
  }

  get ram(): string {
    return this._ram;
  }

  set ram(value: string) {
    this._ram = value;
  }

  get dd(): string {
    return this._dd;
  }

  set dd(value: string) {
    this._dd = value;
  }

  get dateAchat(): Date {
    return this._dateAchat;
  }

  set dateAchat(value: Date) {
    this._dateAchat = value;
  }
}
