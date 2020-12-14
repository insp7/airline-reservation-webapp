import { Component, OnInit } from '@angular/core'

import { FlightPreference } from 'app/flight-preference';
import { FlightService } from 'app/flight.service';
import { Flight } from 'app/flight';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-flights-search',
  templateUrl: './flights-search.component.html',
  styleUrls: ['./flights-search.component.css']
})
export class FlightsSearchComponent implements OnInit {
  flightPreference: FlightPreference = new FlightPreference()
  flights: Flight[]
  allFlights: Observable<Flight[]>

  constructor(private flightService: FlightService, private router: Router) { }

  ngOnInit(): void {
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
