import {ExpertisePK} from './expertise-pk';

export class Expertise {
  constructor(
    private _key?: ExpertisePK) {
  }

  get key(): number {
    return this._key;
  }

  set key(value: number) {
    this._key = value;
  }

}
