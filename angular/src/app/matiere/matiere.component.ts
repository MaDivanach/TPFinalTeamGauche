import { Component, OnInit } from '@angular/core';
import {Matiere} from '../model/matiere';
import {MatiereService} from '../service/matiere.service';

@Component({
  selector: 'app-matiere',
  templateUrl: './matiere.component.html',
  styleUrls: ['./matiere.component.css']
})
export class MatiereComponent implements OnInit {
  matieres: Matiere[];

  constructor(private matiereService: MatiereService) { }

  ngOnInit() {
    this.list();
  }

  public list(){
    this.matiereService.list().subscribe(resp =>{
      this.matieres = resp;
    });
  }

  public delete(id: number){
    this.matiereService.delete(id).subscribe(resp =>{
      this.list();
    });
  }

}
