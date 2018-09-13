import {Component, Input, OnInit} from '@angular/core';
import {Materiel} from '../model/materiel';
import {_mymateriel} from './tableauMateriel';
import {MaterielService} from '../service/materiel.service';
import {Ordinateur} from '../model/ordinateur';
import {VideoProjecteur} from '../model/videoProjecteur';
import {Salle} from '../model/salle';

@Component({
  selector: 'app-materiel',
  templateUrl: './materiel.component.html',
  styleUrls: ['./materiel.component.css']
})
export class MaterielComponent implements OnInit {

  materiels: Materiel[];
  ordinateurs: Ordinateur[];
  salles: Salle[];
  videoprojecteurs: VideoProjecteur[];


  constructor(private materielService: MaterielService) {
  }


  ngOnInit() {
    this.list();
/*    this.listO();
    this.listV();
    this.listS();*/
  }

  public list() {
    this.materielService.list().subscribe(resp => {
      this.materiels = resp;
    }, error => console.log(error));
  }

/*  public listO() {
    this.materielService.listO().subscribe(resp => {
      this.ordinateurs = resp;
    }, error => console.log(error));
  }

  public listV() {
    this.materielService.listV().subscribe(resp => {
      this.videoprojecteurs = resp;
    }, error => console.log(error));
  }

  public listS() {
    this.materielService.listS().subscribe(resp => {
      this.salles = resp;
    }, error => console.log(error));
  }*/

  public delete(id: number) {
    return this.materielService.delete(id).subscribe(resp => {
        this.list();
      }
    );
  }
}
