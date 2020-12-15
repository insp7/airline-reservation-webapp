import { Component, OnInit } from '@angular/core';
import { Flight } from 'app/flight';
import { FlightPreference } from 'app/flight-preference';
import { Passenger } from 'app/passenger';
import { PassengerService } from 'app/passenger.service';
import { Reservation } from 'app/reservation';
import { ReservationService } from 'app/reservation.service';

@Component({
  selector: 'app-add-passenger-details',
  templateUrl: './add-passenger-details.component.html',
  styleUrls: ['./add-passenger-details.component.css']
})
export class AddPassengerDetailsComponent implements OnInit {

  totalPassengers: number
  flightPreference: FlightPreference
  passengers: Passenger[]
  flight: Flight
  totalFare: number
  bookedSeats: number[]
  userId: number
  reservation: Reservation
  reservationID: number

  constructor(private passengerService: PassengerService, private reservationService: ReservationService) { }

  ngOnInit(): void {
    this.bookedSeats = JSON.parse(localStorage.getItem('bookedSeats'))
    this.flightPreference = JSON.parse(localStorage.getItem('flightPreference'))
    this.totalPassengers = this.flightPreference.passengersCount
    this.flight = JSON.parse(localStorage.getItem('flightObject'))
    this.userId = JSON.parse(localStorage.getItem('userId'))
    // console.log(this.totalPassengers)
    console.log(this.flight)
    console.log(this.flightPreference)
    this.passengers = []
    for (let index = 0; index < this.totalPassengers; index++) {
      this.passengers[index] = new Passenger()
    }

  }

  calculateTotalFare() {
    this.totalFare = 0 // Zero by default
    this.passengers.forEach(passenger => {
      if(passenger.passengerType == 'C')
        this.totalFare += this.flight.fare - (this.flight.fare * 0.25) // 25% discount for children
      else if(passenger.passengerType == 'A')
        this.totalFare += this.flight.fare // no discount for adults
    });
  }

  savePassengers() {
    console.log('Inside save passengers')
    //get resarvation model from local storeage
    this.calculateTotalFare() // calculate total fare
    console.log('Passenger is ', this.passengers)
    console.log('Flight is ', this.flight)
    console.log('Total fare is ', this.totalFare)
    console.log('User id is ', this.userId)

    // FILL RESERVATIONS OBJECT
    this.reservation = new Reservation()
    this.reservation.userId = this.userId
    this.reservation.flightId = this.flight.id
    this.reservation.cabinClass = this.flight.cabinClass.toString()
    this.reservation.totalFare = this.totalFare
    this.reservation.returnedAmount = 0 // set default to zero
    this.reservation.isCancelled = 0 // set default to zero 
    this.reservation.createdAt = '2020-12-15'

    // INSERT INTO RESERVATIONS
    this.reservationService.makeReservation(this.reservation)
      .subscribe((id) => {
        this.reservationID = id
        console.log(this.reservationID)
        this.setReservationIDAndSeatNo();
        console.log('Passengers data: ', this.passengers)
        this.passengerService.savePassengers(this.passengers)
      })

      

    //update model whicb you got from setp1 with total fare
    //call researvation service to save researvation which will return reservation id (create model for this response)
    //this.passengerService.savePassengers(this.passengers);
  }

  setReservationIDAndSeatNo() {
    let i = 0
    this.passengers.forEach(passenger => {
      passenger.reservationID = this.reservationID
      passenger.seatNo = this.bookedSeats[i++]
    });
  }
}
