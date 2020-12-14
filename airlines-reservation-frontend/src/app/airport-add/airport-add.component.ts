import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirportService } from 'app/airport.service';
import { ResponseStatus } from 'app/response-status';

import { Airport } from '../airport';

@Component({
  selector: 'app-airport-add',
  templateUrl: './airport-add.component.html',
  styleUrls: ['./airport-add.component.css']
})
export class AirportAddComponent implements OnInit {
  airport: Airport = new Airport();

  constructor(private airportService: AirportService, private router: Router) { }
  ngOnInit(): void { }

  createAirport() {
    this.airportService.saveAirport(this.airport)
    .subscribe((status: ResponseStatus) => {
      console.log('status is ', status);
      this.router.navigate(['/airports']);
    })
  }
}
