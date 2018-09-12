import {Gestionnaire} from './gestionnaire';
import {Stagiaire} from './stagiaire';
import {Session} from './session';
import {VideoProjecteur} from './videoProjecteur';
import {Salle} from './salle';

export class Formation {

  constructor(
    private _id?: number,
    private _nom?: string,
    private _dateDebut?: Date,
    private _dateFin?: Date,
    private _gestionnaire?: Gestionnaire,
    private _videoProjecteur?: VideoProjecteur,
    private _salle?: Salle,
    private _stagiaires?: Set<Stagiaire>,
    private _sessions?: Set<Session>) {
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get nom(): string {
    return this._nom;
  }

  set nom(value: string) {
    this._nom = value;
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

  get gestionnaire(): Gestionnaire {
    return this._gestionnaire;
  }

  set gestionnaire(value: Gestionnaire) {
    this._gestionnaire = value;
  }

  get videoProjecteur(): VideoProjecteur {
    return this._videoProjecteur;
  }

  set videoProjecteur(value: VideoProjecteur) {
    this._videoProjecteur = value;
  }

  get salle(): Salle {
    return this._salle;
  }

  set salle(value: Salle) {
    this._salle = value;
  }

  get stagiaires(): Set<Stagiaire> {
    return this._stagiaires;
  }

  set stagiaires(value: Set<Stagiaire>) {
    this._stagiaires = value;
  }

  get sessions(): Set<Session> {
    return this._sessions;
  }

  set sessions(value: Set<Session>) {
    this._sessions = value;
  }
}
