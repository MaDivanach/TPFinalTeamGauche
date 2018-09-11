import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {routes} from '../route';
import {MaterielComponent} from './materiel/materiel.component';
import {FormateurComponent} from './formateur/formateur.component';
import {MatiereComponent} from './matiere/matiere.component';
import {SessionComponent} from './session/session.component';
import {PlanningComponent} from './planning/planning.component';
import {FormationComponent} from './planning/formation.component';
import {FormateurService} from './service/formateur.service';
import {FormationService} from './service/formation.service';
import {MaterielService} from './service/materiel.service';
import {SessionService} from './service/session.service';
import {UserService} from './service/user.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MaterielComponent,
    FormateurComponent,
    MatiereComponent,
    SessionComponent,
    PlanningComponent,
    FormationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [
    FormateurService,
    FormationService,
    MaterielService,
    SessionService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
