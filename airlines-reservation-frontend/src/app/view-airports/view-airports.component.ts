import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

import { AirportService } from 'app/airport.service';
import { Airport } from '../airport';

@Component({
  selector: 'app-view-airports',
  templateUrl: './view-airports.component.html',
  styleUrls: ['./view-airports.component.css']
})
export class ViewAirportsComponent implements OnInit {
  airports: Observable<Airport[]>;

  constructor(private airportService: AirportService, private router: Router) { }

  ngOnInit(): void {
    this.getAirports();
  }

  getAirports() {
    this.airports = this.airportService.getAirports();
  }

  deleteAirport(id: number) {   
    console.log(id)
    if(confirm('Are you sure you want to delete this record?')) {
      this.airportService.deleteAirport(id)
        .subscribe((result) => {
          console.log('result is ', result)
          // this.router.navigate['airports']
          window.location.reload();
        })
    }    
  }
}