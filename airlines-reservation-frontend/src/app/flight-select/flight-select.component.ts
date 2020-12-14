import { Component, OnInit } from '@angular/core';

import { Flight } from 'app/flight'
import { FlightPreference } from 'app/flight-preference';
import { FlightService } from 'app/flight.service';
import { ReservationService } from 'app/reservation.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-flight-select',
  templateUrl: './flight-select.component.html',
  styleUrls: ['./flight-select.component.css']
})
export class FlightSelectComponent implements OnInit {
  flights: Flight[]
  selectedFlightId: number
  selectedFlight: Observable<Flight>
  flightPreference: FlightPreference

  constructor(private reservationService: ReservationService, private flightService: FlightService) { }

  ngOnInit(): void {
    this.flights = JSON.parse(localStorage.getItem('flightsByPreference'))
    this.flightPreference = JSON.parse(localStorage.getItem('flightPreference'))
    this.selectedFlight = this.flightService.getFlightById(this.selectedFlightId)
  }

  selectFlight(id: number) {
    this.selectedFlightId = id
    localStorage.setItem('flightId', '' + id)
    // if(localStorage.getItem('userID')) {
      // this.reservationService.makeReservation(65, id, this.selectedFlightId.cabinClass, )
    // }
    
  }

}
