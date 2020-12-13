import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from '@angular/router';
import { Airport } from 'app/airport';
import { AirportService } from 'app/airport.service';

import { first } from "rxjs/operators";


@Component({
  selector: 'app-airport-edit',
  templateUrl: './airport-edit.component.html',
  styleUrls: ['./airport-edit.component.css']
})
export class AirportEditComponent implements OnInit {
  airport: Airport;
  editForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private airportService: AirportService) { }
  ngOnInit(): void { 
    let airportId = window.localStorage.getItem("editAirportID");
    if(!airportId) {
      alert("Invalid action.")
      this.router.navigate(['view-airports']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      city: ['', Validators.required],
      state: ['', Validators.required]
    });
    this.airportService.getAirportById(+airportId)
      .subscribe( data => {
        this.editForm.setValue(data.result);
      });
  }

  updateAirport(airport: Airport) {
    this.airportService.updateUser(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          if(data.status === 200) {
            alert('User updated successfully.');
            this.router.navigate(['view-airports']);
          }else {
            alert(data.message);
          }
        },
        error => {
          alert(error);
        });
  }
}
