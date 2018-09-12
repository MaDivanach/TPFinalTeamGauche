import {Component, OnInit} from '@angular/core';
import {Materiel} from '../model/materiel';
import {MaterielService} from '../service/materiel.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Ordinateur} from '../model/ordinateur';
import {Salle} from '../model/salle';
import {VideoProjecteur} from '../model/videoProjecteur';

@Component({
  selector: 'app-materiel-edit',
  templateUrl: './materiel-edit.component.html',
  styleUrls: ['./materiel-edit.component.css']
})
export class MaterielEditComponent implements OnInit {

  materiel: Materiel;

  constructor(private materielService: MaterielService, private ar: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {

/*    this.ar.params.subscribe(params => {
      console.log(this.materiel);
      if (params.type === 'ordinateur') {
        this.materiel = new Ordinateur();
      } else if (params.type === 'salle') {
        this.materiel = new Salle();
      } else if (params.type === 'videoprojecteur') {
        this.materiel = new VideoProjecteur();
      }
      if (params.id) {
        this.materielService.findById(params.id).subscribe(resp => {
          this.materiel = resp;
          console.log(this.materiel);
        });
      }
    });*/

  }
/*
  public save() {
    this.materielService.save(this.materiel).subscribe(resp => {
      this.router.navigate(['/materiel']);
    });
  }*/

}
