import {Component, OnInit} from '@angular/core';
import {Session} from '../model/session';
import {ActivatedRoute, Router} from '@angular/router';
import {SessionService} from '../service/session.service';

@Component({
  selector: 'app-session-edit',
  templateUrl: './session-edit.component.html',
  styleUrls: ['./session-edit.component.css']
})
export class SessionEditComponent implements OnInit {

  session: Session = new Session();

  constructor(private sessionService: SessionService, private ar: ActivatedRoute, private router: Router) {
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
