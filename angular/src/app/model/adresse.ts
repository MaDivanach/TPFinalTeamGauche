export class Adresse {

  constructor(private _numero?: number, private _rue?: string, private _codePostal?: string, private _ville?: string) {
  }


  get numero(): number {
    return this._numero;
  }

  set numero(value: number) {
    this._numero = value;
  }

  get rue(): string {
    return this._rue;
  }

  set rue(value: string) {
    this._rue = value;
  }

  get codePostal(): string {
    return this._codePostal;
  }

  set codePostal(value: string) {
    this._codePostal = value;
  }

  get ville(): string {
    return this._ville;
  }

  set ville(value: string) {
    this._ville = value;
  }
}
