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
import {SessionComponent} from './planning/session.component';
import {PlanningComponent} from './planning/planning.component';
import {FormationComponent} from './planning/formation.component';
import {MaterielEditComponent} from './materiel/materiel-edit.component';
import {MatiereEditComponent} from './matiere/matiere-edit.component';
import {FormationEditComponent} from './planning/formation-edit.component';
import {SessionEditComponent} from './planning/session-edit.component';
import {FormationService} from './service/formation.service';
import {MaterielService} from './service/materiel.service';
import {SessionService} from './service/session.service';
import {UserService} from './service/user.service';
import {AuthentificationComponent} from './authentification/authentification.component';
import {UserComponent} from './authentification/user.component';
import {ExpertiseComponent} from './formateur/expertise.component';
import {UserEditComponent} from './authentification/user-edit.component';
import {ExpertiseEditComponent} from './formateur/expertise-edit.component';
import { LoginComponent } from './login/login.component';
import {AuthService} from './service/auth.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MaterielComponent,
    FormateurComponent,
    MatiereComponent,
    SessionComponent,
    PlanningComponent,
    FormationComponent,
    MaterielEditComponent,
    MatiereEditComponent,
    FormationEditComponent,
    SessionEditComponent,
    AuthentificationComponent,
    UserComponent,
    ExpertiseComponent,
    UserEditComponent,
    ExpertiseEditComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [
    FormationService,
    MaterielService,
    SessionService,
    UserService,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
