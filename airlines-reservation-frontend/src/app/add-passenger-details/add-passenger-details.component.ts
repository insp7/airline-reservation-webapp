import { Component, OnInit } from '@angular/core';
import { FlightPreference } from 'app/flight-preference';
import { Passenger } from 'app/passenger';
import { PassengerService } from 'app/passenger.service';

@Component({
  selector: 'app-add-passenger-details',
  templateUrl: './add-passenger-details.component.html',
  styleUrls: ['./add-passenger-details.component.css']
})
export class AddPassengerDetailsComponent implements OnInit {

  totalPassengers: number
  flightPreference: FlightPreference
  passengers: Passenger[]

  constructor(private passengerService: PassengerService) { }

  ngOnInit(): void {
    this.flightPreference = JSON.parse(localStorage.getItem('flightPreference'))
    this.totalPassengers = this.flightPreference.passengersCount
    console.log(this.totalPassengers)
    this.passengers = [];
    for (let index = 0; index < this.totalPassengers; index++) {
      this.passengers[index] = new Passenger()
    }

  }

  savePassengers() {
    //get resarvation model from local storeage
    //calculate total fare
    //update model whicb you got from setp1 with total fare
    //call researvation service to save researvation which will return reservation id (create model for this response)


   
    
    //this.passengerService.savePassengers(this.passengers);
  }
}
