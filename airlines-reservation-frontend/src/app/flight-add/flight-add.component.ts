import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirportService } from 'app/airport.service';
import { Flight } from 'app/flight';
import { FlightService } from 'app/flight.service';
import { ResponseStatus } from 'app/response-status';
import { Airport } from 'app/airport';


@Component({
  selector: 'app-flight-add',
  templateUrl: './flight-add.component.html',
  styleUrls: ['./flight-add.component.css']
})
export class FlightAddComponent implements OnInit {
  flight: Flight = new Flight()
  airports: Airport[]
  cabinClass: number

  constructor(private flightService: FlightService, private router: Router, private airportService: AirportService) { }

  ngOnInit(): void {
    this.airportService.getAirports()
      .subscribe((airports: Airport[]) => {
        this.airports = airports
        console.log('Airports are: ', this.airports)
      })
  }

  createFlight() {
    this.flight.capacity = 60 // manually setting 60 as flight capacity
    this.flightService.saveFlight(this.flight)
    .subscribe((status: ResponseStatus) => {
      console.log('status is ', status);
      this.router.navigate(['/flights']);
    })
  }
}
