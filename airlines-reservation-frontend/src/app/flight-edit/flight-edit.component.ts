import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from "@angular/forms";
import { ActivatedRoute, Router } from '@angular/router';
import { Flight } from 'app/flight';
import { FlightService } from 'app/flight.service';
import { ResponseStatus } from 'app/response-status';

@Component({
  selector: 'app-flight-edit',
  templateUrl: './flight-edit.component.html',
  styleUrls: ['./flight-edit.component.css']
})
export class FlightEditComponent implements OnInit {

  flight: Flight
  editForm: FormGroup = new FormGroup({
    id: new FormControl(),
    source: new FormControl(),
    destination: new FormControl(),
    departureDate: new FormControl(),
    arrivalDate: new FormControl(),
    capacity: new FormControl(),
    cabinClass: new FormControl(),
    fare: new FormControl()
  })

  constructor(private formBuilder: FormBuilder, private router: Router, private flightService: FlightService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    console.log(this.activatedRoute.snapshot.params.id);
    this.flightService.getFlightById(this.activatedRoute.snapshot.params.id)
      .subscribe((flight) => {
        this.editForm = new FormGroup({
          id: new FormControl(flight['id']),
          source: new FormControl(flight['source']),
          destination: new FormControl(flight['destination']),
          departureDate: new FormControl(flight['departureDate']),
          arrivalDate: new FormControl(flight['arrivalDate']),
          capacity: new FormControl(flight['capacity']),
          cabinClass: new FormControl(flight['cabinClass']),
          fare: new FormControl(flight['fare'])
        })   
      })
  }

  updateFlight() {
    this.flightService.updateFlight(this.editForm.value)
      .subscribe((status: ResponseStatus) => {
        console.log(status)
        this.router.navigate['/flights']
      }) 
  }

}
