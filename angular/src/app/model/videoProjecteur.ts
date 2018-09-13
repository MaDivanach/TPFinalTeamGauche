import {Formation} from './Formation';
import {Materiel} from './materiel';

export class VideoProjecteur extends Materiel {

  constructor(private _formations?: Formation[]) {
    super();
    this.type = 'videoprojecteur';
  }

  get formationsVideoProj(): Formation[] {
    return this._formations;
  }

  set formationsVideoProj(value: Formation[]) {
    this._formations = value;
  }
}
