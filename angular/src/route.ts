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

export const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'user', component: UserComponent},
  {path: 'user/create/:type', component: UserEditComponent},
  {path: 'user/edit/:type/:id', component: UserEditComponent},
  {path: 'materiel', component: MaterielComponent},
  {path: 'materiel/create/:type', component: MaterielEditComponent},
  {path: 'materiel/edit/:type/:id', component: MaterielEditComponent},
  {path: 'formation', component: FormationComponent},
  {path: 'formation/create', component: FormationEditComponent},
  {path: 'formation/edit/:id', component: FormationEditComponent},
  {path: 'session', component: SessionComponent},
  {path: 'session/create', component: SessionEditComponent},
  {path: 'session/edit/:id', component: SessionEditComponent},
  {path: 'matiere', component: MatiereComponent},
  {path: 'matiere/create', component: MatiereEditComponent},
  {path: 'matiere/edit/:id', component: MatiereEditComponent},
  {path: 'expertise', component: ExpertiseComponent},
  {path: 'expertise/create', component: ExpertiseEditComponent},
  {path: 'expertise/edit/:id', component: ExpertiseEditComponent},
  {path: 'formateur', component: FormateurComponent},
  {path: 'planning', component: PlanningComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
];



