import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';


import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';

import { AppComponent } from './app.component';

import { DashboardComponent } from './dashboard/dashboard.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { TableListComponent } from './table-list/table-list.component';
import { TypographyComponent } from './typography/typography.component';
import { IconsComponent } from './icons/icons.component';
import { MapsComponent } from './maps/maps.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { UpgradeComponent } from './upgrade/upgrade.component';
import {
  AgmCoreModule
} from '@agm/core';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { UserService } from './user.service';
import { PaymentComponent } from './payment/payment.component';
import { LoginComponent } from './login/login.component';
import { FlightsSearchComponent } from './flights-search/flights-search.component';
import { ViewFlightsComponent } from './view-flights/view-flights.component';
import { ViewAirportsComponent } from './view-airports/view-airports.component';
import { AirportAddComponent } from './airport-add/airport-add.component';
import { AirportEditComponent } from './airport-edit/airport-edit.component';
import { FlightEditComponent } from './flight-edit/flight-edit.component';
import { FlightSelectComponent } from './flight-select/flight-select.component';
import { AddPassengerDetailsComponent } from './add-passenger-details/add-passenger-details.component';
import { SelectSeatsComponent } from './select-seats/select-seats.component';

@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ComponentsModule,
    RouterModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({
      apiKey: 'YOUR_GOOGLE_MAPS_API_KEY'
    })
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    RegisterUserComponent,
    PaymentComponent,
    LoginComponent,
    FlightsSearchComponent,
    ViewFlightsComponent,
    ViewAirportsComponent,
    AirportAddComponent,
    AirportEditComponent,
    FlightEditComponent,
    FlightSelectComponent,
    AddPassengerDetailsComponent,
    SelectSeatsComponent,

  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
