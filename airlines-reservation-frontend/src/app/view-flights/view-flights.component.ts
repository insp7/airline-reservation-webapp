import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

import { Flight } from 'app/flight';
import { FlightService } from 'app/flight.service';
import { AirportService } from 'app/airport.service';
import { Airport } from 'app/airport'

@Component({
  selector: 'app-view-flights',
  templateUrl: './view-flights.component.html',
  styleUrls: ['./view-flights.component.css']
})
export class ViewFlightsComponent implements OnInit {

  flights: Flight[]
  airports: Airport[]


  constructor(private flightService: FlightService, private router: Router, private airportService: AirportService) { }

  ngOnInit(): void {
    this.airportService.getAirports()
      .subscribe((airports: Airport[]) => {
        this.airports = airports
        console.log('Airports are: ', this.airports)
      })
    this.getFlights();
  }

  getFlights() {
    this.flightService.getFlights()
      .subscribe((flights: Flight[]) => {
        console.log(flights)
        this.flights = flights
      })
    
  }

  getName(id: number) {
    let name = 'NA';
    this.airports.forEach(airport => {
      if(airport.id == id)
        name = airport.name
    });
    return name;
  }

  getCabinClassName(id: number) {
    let name = 'NA'
    if(id == 1)
      name = 'Business'
    else if(id == 2)
      name = 'Economy'
    return name;
  }

  deleteFlight(id: number) {   
    console.log(id)
    if(confirm('Are you sure you want to delete this record?')) {
      this.flightService.deleteFlight(id)
        .subscribe((result) => {
          console.log('result is ', result)
          // this.router.navigate['airports']
          window.location.reload();
        })
    }    
  }
}
