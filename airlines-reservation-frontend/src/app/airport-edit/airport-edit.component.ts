import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from '@angular/router';
import { Airport } from 'app/airport';
import { AirportService } from 'app/airport.service';
import { ResponseStatus } from 'app/response-status';

@Component({
  selector: 'app-airport-edit',
  templateUrl: './airport-edit.component.html',
  styleUrls: ['./airport-edit.component.css']
})
export class AirportEditComponent implements OnInit {
  airport: Airport
  editForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    city: new FormControl(),
    state: new FormControl()
  })

  constructor(private formBuilder: FormBuilder, private router: Router, private airportService: AirportService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    console.log(this.activatedRoute.snapshot.params.id);
    this.airportService.getAirportById(this.activatedRoute.snapshot.params.id)
      .subscribe((airport) => {
        this.editForm = new FormGroup({
          id: new FormControl(airport['id']),
          name: new FormControl(airport['name']),
          city: new FormControl(airport['city']),
          state: new FormControl(airport['state'])
        })    
      })
  }

  updateAirport() {
    this.airportService.updateAirport(this.editForm.value)
      .subscribe((status: ResponseStatus) => {
        console.log(status)
        this.router.navigate['/airports']
      }) 
  }
}
