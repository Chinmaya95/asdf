import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AddmovieComponent } from './addmovie/addmovie.component';
import { SearchmovieComponent } from './searchmovie/searchmovie.component';
import { Routes, RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


const routes: Routes = [
  { path: "addMovie", component: AddmovieComponent },
  { path: "searchMovie", component: SearchmovieComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    AddmovieComponent,
    SearchmovieComponent,
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
