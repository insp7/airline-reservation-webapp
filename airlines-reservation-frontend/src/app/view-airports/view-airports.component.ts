import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirportService } from 'app/airport.service';
import { Observable } from 'rxjs';

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
    console.log(this.airports);
  }

  getAirports() {
    this.airports = this.airportService.getAirports();
  }

  edit(airport: Airport) {
    console.log(airport);
    window.localStorage.removeItem("editAirportID");
    window.localStorage.setItem("editAirportID", airport.id.toString());
    this.router.navigate(['edit-airport']);
  }
}