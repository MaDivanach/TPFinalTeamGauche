import {Role} from './role.enum';

export class User {
  constructor(private _nom?: string, private _prenom?: string, private _username?: string, private _password?: string, private _telephone?: string, private _role?: Role, private _id?: number) {
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

  get telephone(): string {
    return this._telephone;
  }

  set telephone(value: string) {
    this._telephone = value;
  }

  get role(): Role {
    return this._role;
  }

  set role(value: Role) {
    this._role = value;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }
}
