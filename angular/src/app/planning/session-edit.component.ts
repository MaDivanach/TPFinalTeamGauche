import {Component, OnInit} from '@angular/core';
import {Session} from '../model/session';
import {ActivatedRoute, Router} from '@angular/router';
import {SessionService} from '../service/session.service';
import {Matiere} from '../model/matiere';
import {Formateur} from '../model/formateur';
import {Formation} from '../model/formation';
import {UserService} from '../service/user.service';
import {MatiereService} from '../service/matiere.service';
import {FormationService} from '../service/formation.service';

@Component({
  selector: 'app-session-edit',
  templateUrl: './session-edit.component.html',
  styleUrls: ['./session-edit.component.css']
})
export class SessionEditComponent implements OnInit {

  session: Session = new Session();
  matieres: Matiere[];
  formateurs: Formateur[];
  formation: Formation[];

  constructor(
    private sessionService: SessionService,
    private ar: ActivatedRoute,
    private router: Router,
    private userService: UserService,
    private matiereService: MatiereService,
    private formationService: FormationService) {
  }

  ngOnInit() {
    this.ar.params.subscribe(params => {
      if (params.id) {
        this.sessionService.findById(params.id).subscribe(resp => {
          this.session = resp;
        });
      }
    });
  }

  public save() {
    this.sessionService.save(this.session).subscribe(resp => {
      this.router.navigate(['/session']);
    });
  }

}
