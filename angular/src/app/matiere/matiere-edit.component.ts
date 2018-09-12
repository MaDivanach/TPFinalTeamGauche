import {Component, OnInit} from '@angular/core';
import {Matiere} from '../model/matiere';
import {MatiereService} from '../service/matiere.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Niveau} from '../model/niveau.enum';

@Component({
  selector: 'app-matiere-edit',
  templateUrl: './matiere-edit.component.html',
  styleUrls: ['./matiere-edit.component.css']
})
export class MatiereEditComponent implements OnInit {

  debutant: Niveau = Niveau.Debutant;
  intermediaire: Niveau = Niveau.Intermediaire;
  avance: Niveau = Niveau.Avance;
  expert: Niveau = Niveau.Expert;
  matiere: Matiere = new Matiere();

  constructor(
    private matiereService: MatiereService,
    private ar: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit() {
    this.ar.params.subscribe(params => {
      if (params.id) {
        this.matiereService.findById(params.id).subscribe(resp => {
          this.matiere = resp;
        });
      }
    });
  }

  public save() {
    this.matiereService.save(this.matiere).subscribe(resp => {
      this.router.navigate(['/matiere']);
    });
  }

}
