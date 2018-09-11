import {Component, OnInit} from '@angular/core';
import {Formation} from "../model/Formation";
import {FormationService} from "../service/formation.service";

@Component({
  selector: 'app-formation-edit',
  templateUrl: './formation-edit.component.html',
  styleUrls: ['./formation-edit.component.css']
})
export class FormationEditComponent implements OnInit {

  formation: Formation;

  constructor(private formationService: FormationService, private ar: ActivatedRoute, private router: Router) {

  }


  ngOnInit() {
    this.ar.params.subscribe(params => {
      /*  console.log(params);*/
      console.log(this.formation);
      if (params.id) {
        this.formationService.findById(params.id).subscribe(resp => {
          this.formation = resp;
          console.log(this.formation);
        });
      }
    });
  }

  public save() {
    this.formationService.save(this.formation).subscribe(resp => {
      this.router.navigate([`/formation`]);
    });
  }

}
