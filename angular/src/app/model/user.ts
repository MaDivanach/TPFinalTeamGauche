import {Role} from './role.enum';
import {Adresse} from './adresse';

export class User {
  constructor(
    private _id?: number,
    private _username?: string,
    private _password?: string,
    private _nom?: string,
    private _prenom?: string,
    private _telephone?: string,
    private _role?: Role,
    private _adresse?: Adresse,
    private _type?: String
    /*private _enable?: boolean,*/
  ) {
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get username(): string {
    return this._username;
  }

  set username(value: string) {
    this._username = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  /*  get enable(): boolean {
      return this._enable;
    }

    set enable(value: boolean) {
      this._enable = value;
    }*/

  get role(): Role {
    return this._role;
  }

  set role(value: Role) {
    this._role = value;
  }

  get nom(): string {
    return this._nom;
  }

  set nom(value: string) {
    this._nom = value;
  }

  get prenom(): string {
    return this._prenom;
  }

  set prenom(value: string) {
    this._prenom = value;
  }

  get telephone(): string {
    return this._telephone;
  }

  set telephone(value: string) {
    this._telephone = value;
  }

  get adresse(): Adresse {
    return this._adresse;
  }

  set adresse(value: Adresse) {
    this._adresse = value;
  }

  get type(): String {
    return this._type;
  }

  set type(value: String) {
    this._type = value;
  }
}
