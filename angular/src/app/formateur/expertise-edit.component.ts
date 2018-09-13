import {Component, OnInit} from '@angular/core';
import {Expertise} from '../model/expertise';
import {ActivatedRoute, Router} from '@angular/router';
import {ExpertiseService} from '../service/expertise.service';
import {Formateur} from '../model/formateur';
import {FormationService} from '../service/formation.service';
import {MatiereService} from '../service/matiere.service';

@Component({
  selector: 'app-expertise-edit',
  templateUrl: './expertise-edit.component.html',
  styleUrls: ['./expertise-edit.component.css']
})
export class ExpertiseEditComponent implements OnInit {

  expertise: Expertise = new Expertise();
  formateurs: Formateur[];

  constructor(
    private expertiseService: ExpertiseService,
    private ar: ActivatedRoute,
    private router: Router,
    private formateurService: FormationService,
    private matiereService: MatiereService) {
  }

  ngOnInit() {
    this.ar.params.subscribe(params => {
      if (params.id) {
        this.expertiseService.findById(params.id).subscribe(resp => {
          this.expertise = resp;
        });
      }
    });
  }

  public save() {
    this.expertiseService.save(this.expertise).subscribe(resp => {
      this.router.navigate(['/expertise']);
    });
  }

}
