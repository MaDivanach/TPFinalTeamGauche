export class Expertise {
  constructor(
    private _key?: number) {
  }

  get key(): number {
    return this._key;
  }

  set key(value: number) {
    this._key = value;
  }

}
