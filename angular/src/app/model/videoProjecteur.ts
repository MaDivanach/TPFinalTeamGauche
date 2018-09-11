import {Formation} from './Formation';
import {Materiel} from './materiel';

export class VideoProjecteur extends Materiel {

  constructor(private _formationsVideoProj?: Formation[]) {
    super();
  }

  get formationsVideoProj(): Formation[] {
    return this._formationsVideoProj;
  }

  set formationsVideoProj(value: Formation[]) {
    this._formationsVideoProj = value;
  }
}
