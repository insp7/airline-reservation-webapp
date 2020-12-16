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
import { FlightEditComponent } from './flight-edit/flight-edit.component';
import { FlightSelectComponent } from './flight-select/flight-select.component';
import { SelectSeatsComponent } from './select-seats/select-seats.component';
import { AddPassengerDetailsComponent } from './add-passenger-details/add-passenger-details.component';
import { ViewReservationsComponent } from './view-reservations/view-reservations.component';
import { UserReservationsComponent } from './user-reservations/user-reservations.component';
import { FlightAddComponent } from './flight-add/flight-add.component';

const routes: Routes = [
  
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterUserComponent },  
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' }, 
  { path: '', component: AdminLayoutComponent,
    children: [
    { path: 'airports', component: ViewAirportsComponent },
    { path: 'airport/edit/:id', component: AirportEditComponent },
    { path: 'airport/add', component: AirportAddComponent },
    { path: 'flights', component: ViewFlightsComponent },
    { path: 'flight/edit/:id', component: FlightEditComponent },
    { path: 'flight/add', component: FlightAddComponent },
    { path: 'flights-search', component: FlightsSearchComponent },
    { path: 'flights/select', component: FlightSelectComponent },
    { path: 'flights/select-seats', component: SelectSeatsComponent },
    { path: 'flights/add-passengers', component: AddPassengerDetailsComponent },
    { path: 'reservations', component: ViewReservationsComponent },
    { path: 'reservations-user', component: UserReservationsComponent },
    { path: 'payment', component: PaymentComponent },]
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
