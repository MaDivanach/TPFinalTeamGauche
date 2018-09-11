import {ExpertisePK} from './expertise-pk';

export class Expertise {
  constructor(
    private _key?: ExpertisePK) {
  }

  get key(): ExpertisePK {
    return this._key;
  }

  set key(value: ExpertisePK) {
    this._key = value;
  }

}
