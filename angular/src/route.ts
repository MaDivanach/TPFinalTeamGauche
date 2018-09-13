import {Routes} from '@angular/router';
import {HomeComponent} from './app/home/home.component';
import {FormateurComponent} from './app/formateur/formateur.component';
import {PlanningComponent} from './app/planning/planning.component';
import {MaterielComponent} from './app/materiel/materiel.component';
import {MatiereComponent} from './app/matiere/matiere.component';
import {UserComponent} from './app/authentification/user.component';
import {FormationComponent} from './app/planning/formation.component';
import {SessionComponent} from './app/planning/session.component';
import {ExpertiseComponent} from './app/formateur/expertise.component';
import {UserEditComponent} from './app/authentification/user-edit.component';
import {MaterielEditComponent} from './app/materiel/materiel-edit.component';
import {FormationEditComponent} from './app/planning/formation-edit.component';
import {SessionEditComponent} from './app/planning/session-edit.component';
import {MatiereEditComponent} from './app/matiere/matiere-edit.component';
import {ExpertiseEditComponent} from './app/formateur/expertise-edit.component';
import {LoginComponent} from './app/login/login.component';
import {AuthGuardService} from './app/service/auth-guard.service';


export const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'user', canActivate: [AuthGuardService], component: UserComponent},
  {path: 'login', component: LoginComponent},
  {path: 'user/create/:type', component: UserEditComponent},
  {path: 'user/edit/:type/:id', component: UserEditComponent},
  {path: 'materiel', canActivate: [AuthGuardService], component: MaterielComponent},
  {path: 'materiel/create/:type', component: MaterielEditComponent},
  {path: 'materiel/edit/:type/:id', component: MaterielEditComponent},
  {path: 'formation', canActivate: [AuthGuardService], component: FormationComponent},
  {path: 'formation/create', component: FormationEditComponent},
  {path: 'formation/edit/:id', component: FormationEditComponent},
  {path: 'formation/stagiaireinformation/:id', component: UserComponent},
  {path: 'formation/sessioninformation/:id', component: SessionComponent},
  {path: 'session', canActivate: [AuthGuardService], component: SessionComponent},
  {path: 'session/create', component: SessionEditComponent},
  {path: 'session/edit/:id', component: SessionEditComponent},
  {path: 'matiere', canActivate: [AuthGuardService], component: MatiereComponent},
  {path: 'matiere/create', component: MatiereEditComponent},
  {path: 'matiere/edit/:id', component: MatiereEditComponent},
  {path: 'expertise', canActivate: [AuthGuardService], component: ExpertiseComponent},
  {path: 'expertise/create', component: ExpertiseEditComponent},
  {path: 'expertise/edit/:id', component: ExpertiseEditComponent},
  {path: 'formateur', component: FormateurComponent},
  {path: 'planning', component: PlanningComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
];



