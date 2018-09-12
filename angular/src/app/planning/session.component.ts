import {Component, OnInit} from '@angular/core';
import {SessionService} from '../service/session.service';
import {Session} from '../model/session';

@Component({
  selector: 'app-session',
  templateUrl: './session.component.html',
  styleUrls: ['./session.component.css']
})
export class SessionComponent implements OnInit {

  sessions: Session[];

  constructor(private sessionService: SessionService) {
  }

  ngOnInit() {
    this.list();
  }

  public list() {
    this.sessionService.list().subscribe(resp => {
      this.sessions = resp;
    });
  }

  public delete(id: number) {
    this.sessionService.delete(id).subscribe(resp => {
      this.list();
    });
  }

}
