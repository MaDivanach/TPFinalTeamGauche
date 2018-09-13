import {Component, OnInit} from '@angular/core';
import {Formation} from '../model/formation';
import {FormationService} from '../service/formation.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MaterielService} from '../service/materiel.service';
import {UserService} from '../service/user.service';
import {Gestionnaire} from '../model/gestionnaire';
import {Salle} from '../model/salle';
import {VideoProjecteur} from '../model/videoProjecteur';
import {User} from '../model/user';

@Component({
  selector: 'app-formation-edit',
  templateUrl: './formation-edit.component.html',
  styleUrls: ['./formation-edit.component.css']
})
export class FormationEditComponent implements OnInit {

  formation: Formation = new Formation();
  gestionnaires: Gestionnaire[];
  salles: Salle[];
  videoprojecteurs: VideoProjecteur[];
  idgestion: number;

  constructor(
    private formationService: FormationService,
    private ar: ActivatedRoute,
    private router: Router,
    private materielService: MaterielService,
    private userService: UserService) {

  }

  ngOnInit() {
    this.ar.params.subscribe(params => {
      /*  console.log(params);*/
      console.log(this.formation);
      if (params.id) {
        this.formationService.findById(params.id).subscribe(resp => {
          this.formation = resp;
          this.idgestion = this.formation.gestionnaire.id;
          console.log(this.formation);
        });
      }
      this.userService.listG().subscribe(
        resp => {
          this.gestionnaires = resp;
        }
      );
    });
  }


  public save() {
    this.userService.findById(this.idgestion).subscribe(resp => {
      // @ts-ignore
      this.formation.gestionnaire = resp;

      this.formationService.save(this.formation).subscribe(resp => {
        this.router.navigate([`/formation`]);
      });
    });
  }
}
