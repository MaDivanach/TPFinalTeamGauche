import {Routes} from '@angular/router';
import {HomeComponent} from './app/home/home.component';
import {FormateurComponent} from './app/formateur/formateur.component';
import {PlanningComponent} from './app/planning/planning.component';
import {MaterielComponent} from './app/materiel/materiel.component';
import {MatiereComponent} from './app/matiere/matiere.component';

export const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'formateur', component: FormateurComponent},
  {path: 'planning', component: PlanningComponent},
  {path: 'materiel', component: MaterielComponent},
  {path: 'matiere', component: MatiereComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
];



