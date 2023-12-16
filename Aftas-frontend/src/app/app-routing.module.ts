import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home/home.component';
import { CompetitionsComponent } from './components/competition/competitions/competitions.component';
import { CompetitionDetailComponent } from './components/competition/competition-detail/competition-detail.component';

const routes: Routes = [
  {path : '' , component : HomeComponent},
  {path : 'Competition' , component : CompetitionsComponent},
  {path : 'Competition/:code' , component : CompetitionDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
