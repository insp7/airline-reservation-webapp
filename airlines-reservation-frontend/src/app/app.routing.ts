import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';
import { BrowserModule  } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { PaymentComponent } from './payment/payment.component';
import { LoginComponent } from './login/login.component';
import { FlightsSearchComponent } from './flights-search/flights-search.component';
import { ViewFlightsComponent } from './view-flights/view-flights.component';
import { ViewAirportsComponent } from './view-airports/view-airports.component';
import { AirportAddComponent } from './airport-add/airport-add.component';
import { AirportEditComponent } from './airport-edit/airport-edit.component';

const routes: Routes = [
  { path: 'view-airports', component: ViewAirportsComponent },
  { path: 'edit-airport', component: AirportEditComponent },
  { path: 'add-airport', component: AirportAddComponent },
  { path: 'view-flights', component: ViewFlightsComponent },
  { path: 'flights-search', component: FlightsSearchComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterUserComponent },
  { path: 'payment', component: PaymentComponent },  
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' }, 
  { path: '', component: AdminLayoutComponent,
    children: [{
      path: '',
      loadChildren: './layouts/admin-layout/admin-layout.module#AdminLayoutModule'
    }]
  }
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
  ],
})
export class AppRoutingModule { }
