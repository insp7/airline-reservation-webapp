import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FlightService } from 'app/flight.service';
import { PassengerService } from 'app/passenger.service';
import { Reservation } from 'app/reservation';
import { ReservationService } from 'app/reservation.service';
import { ResponseStatus } from 'app/response-status';
import { Flight } from 'app/flight';

@Component({
  selector: 'app-user-reservations',
  templateUrl: './user-reservations.component.html',
  styleUrls: ['./user-reservations.component.css']
})
export class UserReservationsComponent implements OnInit {
  reservations: Reservation[]
  userId = JSON.parse(localStorage.getItem('userId'))
  freedSeats: number
  flight: Flight

  constructor(private reservationService: ReservationService, private passengerService: PassengerService, private flightService: FlightService, private router: Router) { }

  ngOnInit(): void {
    this.reservationService.getReservationsForUser(this.userId)
      .subscribe((reservations: Reservation[]) => {
        this.reservations = reservations
        console.log(this.reservations)
      })
  }

  cancelReservation(reservation: Reservation) {
    if(confirm('Are you sure you want to delete this record?')) { 
      reservation.isCancelled = 1
      reservation.returnedAmount = reservation.totalFare * 0.90 // return 90 % of the total fare

      this.reservationService.updateReservation(reservation)
        .subscribe(() => {
          this.passengerService.deletePassengerByReservationId(reservation.id)
            .subscribe((deletedSeats: number) => {
              this.freedSeats = deletedSeats
              console.log('deleted seats ', this.freedSeats)
              this.flightService.getFlightById(reservation.flightId)
                .subscribe((flight: Flight) => {
                  this.flight = flight
                  this.flight.capacity = this.flight.capacity + this.freedSeats
                  console.log('Flight is ', this.flight)
                  this.flightService.updateFlight(this.flight)
                    .subscribe((status: ResponseStatus) => {
                      console.log(status)
                      window.location.reload();
                    }) 
                })
            }) 
        })  
    }
    
  }

  getCabinClassName(id: number) {
    let name = 'NA'
    if(id == 1)
      name = 'Business'
    else if(id == 2)
      name = 'Economy'
    return name;
  }


  getStatusName(id: number) {
    let name = 'NA'
    if(id == 1)
      name = 'Cancelled'
    else if(id == 0)
      name = 'Successful'
    return name;
  }
}
