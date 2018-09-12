import {Component, OnInit} from "@angular/core";
import {FormationService} from "../service/formation.service";
import {Formation} from "../model/formation";

@Component({
  selector: 'app-formation',
  templateUrl: './formation.component.html',
  styleUrls: ['./formation.component.css']
})
export class FormationComponent implements OnInit {
  formation: Formation[];

  constructor(private formationService: FormationService) {
  }

  ngOnInit() {
/*
    this.list();
*/
  }
/*
  public list() {
    this.formationService.list().subscribe(resp => {
      this.formation = resp;
    }, error => console.log(error));
  }

  public delete(id: number) {
    return this.formationService.delete(id).subscribe(resp => {
      this.list();
    });
  }*/
}
