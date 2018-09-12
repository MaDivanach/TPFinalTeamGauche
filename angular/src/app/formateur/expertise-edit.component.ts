import {Component, OnInit} from '@angular/core';
import {Expertise} from '../model/expertise';
import {ActivatedRoute, Router} from '@angular/router';
import {ExpertiseService} from '../service/expertise.service';

@Component({
  selector: 'app-expertise-edit',
  templateUrl: './expertise-edit.component.html',
  styleUrls: ['./expertise-edit.component.css']
})
export class ExpertiseEditComponent implements OnInit {

  expertise: Expertise = new Expertise();

  constructor(private expertiseService: ExpertiseService, private ar: ActivatedRoute, private router: Router) {
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
