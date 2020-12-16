import { Component, OnInit } from '@angular/core'

import { FlightPreference } from 'app/flight-preference';
import { FlightService } from 'app/flight.service';
import { Flight } from 'app/flight';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Airport } from 'app/airport';
import { AirportService } from 'app/airport.service';

@Component({
  selector: 'app-flights-search',
  templateUrl: './flights-search.component.html',
  styleUrls: ['./flights-search.component.css']
})
export class FlightsSearchComponent implements OnInit {
  flightPreference: FlightPreference = new FlightPreference()
  flights: Flight[]
  allFlights: Observable<Flight[]>
  airports: Airport[]

  constructor(private flightService: FlightService, private router: Router, private airportService: AirportService) { }

  ngOnInit(): void {
    this.airportService.getAirports()
      .subscribe((airports: Airport[]) => {
        this.airports = airports
        console.log('Airports are: ', this.airports)
      })
    this.allFlights = this.flightService.getFlights()
  }

  searchFlights() {
    localStorage.setItem('flightPreference', JSON.stringify(this.flightPreference))
    this.flightService.searchFlights(this.flightPreference)
      .subscribe((flightsAccToPreference: Flight[]) => {
        this.flights = flightsAccToPreference
        localStorage.setItem('flightsByPreference', JSON.stringify(this.flights))
        this.router.navigate(['/flights/select'])
      })
  }

}
