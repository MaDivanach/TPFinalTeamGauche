import {Component, OnInit} from '@angular/core';
import {Expertise} from '../model/expertise';
import {ExpertiseService} from '../service/expertise.service';

@Component({
  selector: 'app-expertise',
  templateUrl: './expertise.component.html',
  styleUrls: ['./expertise.component.css']
})
export class ExpertiseComponent implements OnInit {

  expertises: Expertise[];

  constructor(private expertiseService: ExpertiseService) {
  }

  ngOnInit() {
    this.list();
  }

  public list() {
    this.expertiseService.list().subscribe(resp => {
      this.expertises = resp;
    });
  }

  public delete(id: number) {
    this.expertiseService.delete(id).subscribe(resp => {
      this.list();
    });
  }

}
