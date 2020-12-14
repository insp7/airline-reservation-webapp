import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

import { Flight } from 'app/flight';
import { FlightService } from 'app/flight.service';

@Component({
  selector: 'app-view-flights',
  templateUrl: './view-flights.component.html',
  styleUrls: ['./view-flights.component.css']
})
export class ViewFlightsComponent implements OnInit {

  flights: Observable<Flight[]>;

  constructor(private flightService: FlightService, private router: Router) { }

  ngOnInit(): void {
    this.getFlights();
  }

  getFlights() {
    this.flights = this.flightService.getFlights();
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
