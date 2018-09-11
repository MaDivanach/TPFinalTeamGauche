import {Formation} from './Formation';

export class VideoProjecteur {

  constructor(private _formationsVideoProj?: Formation[]) {
  }

  get formationsVideoProj(): Formation[] {
    return this._formationsVideoProj;
  }

  set formationsVideoProj(value: Formation[]) {
    this._formationsVideoProj = value;
  }
}
