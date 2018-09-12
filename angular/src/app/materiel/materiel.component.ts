import {Component, Input, OnInit} from '@angular/core';
import {Materiel} from '../model/materiel';
import {_mymateriel} from './tableauMateriel';
import {MaterielService} from '../service/materiel.service';

@Component({
  selector: 'app-materiel',
  templateUrl: './materiel.component.html',
  styleUrls: ['./materiel.component.css']
})
export class MaterielComponent implements OnInit {

  materiels: Materiel[];

  constructor(private materielService: MaterielService) {
  }


  ngOnInit() {
/*
    this.list();
*/
  }

/*  public list() {
    this.materielService.list().subscribe(resp => {
      this.materiels = resp;
    }, error => console.log(error));
  }

  public delete(id: number) {
    return this.materielService.delete(id).subscribe(resp => {
        this.list();
      }
    );
  }*/
}
