import {Component, OnInit} from '@angular/core';
import {SessionService} from '../service/session.service';
import {Session} from '../model/session';
import {SessionPK} from '../model/session-pk';

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

  /*public delete(key: SessionPK) {
    this.sessionService.delete(key).subscribe(resp => {
      this.list();
    });
  }*/

}
