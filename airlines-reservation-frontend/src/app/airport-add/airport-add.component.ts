import { Component, OnInit } from '@angular/core';
import { AirportService } from 'app/airport.service';

import { Airport } from '../airport';

@Component({
  selector: 'app-airport-add',
  templateUrl: './airport-add.component.html',
  styleUrls: ['./airport-add.component.css']
})
export class AirportAddComponent implements OnInit {
  airport: Airport = new Airport();

  constructor(private airportService: AirportService) { }
  ngOnInit(): void { }

  createAirport() {
    this.airportService.saveAirport(this.airport);
  }
}
