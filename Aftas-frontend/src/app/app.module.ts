import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/utils/navbar/navbar.component';
import { HeaderComponent } from './components/home/header/header.component';
import { HomeComponent } from './components/home/home/home.component';
import { ButtonComponent } from './components/utils/button/button.component';
import { FishesComponent } from './components/home/fishes/fishes.component';
import { HttpClientModule } from '@angular/common/http';
import { FishCardComponent } from './components/home/fish-card/fish-card.component';
import { FooterComponent } from './components/utils/footer/footer.component';
import { AboutComponent } from './components/home/about/about.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HeaderComponent,
    HomeComponent,
    ButtonComponent,
    FishesComponent,
    FishCardComponent,
    FooterComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
