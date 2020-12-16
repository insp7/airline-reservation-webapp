import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FlightService } from 'app/flight.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-select-seats',
  templateUrl: './select-seats.component.html',
  styleUrls: ['./select-seats.component.css']
})
export class SelectSeatsComponent implements OnInit {
  flightId: number
  userId: number
  bookedSeats: number[]
  mySeats= []
  testBookedSeats = [52, 53, 54, 55]
  temp=[]
  constructor(private flightService: FlightService, private router: Router) { }

  ngOnInit(): void {
    this.flightId = JSON.parse(localStorage.getItem('flightId'))
    this.userId = JSON.parse(localStorage.getItem('userId'))
    console.log('user id is ' + this.userId + ', flight id is ' + this.flightId)
    this.flightService.getBookedSeats(this.flightId)
      .subscribe((seats) => {
        this.bookedSeats = seats
        console.log(this.bookedSeats)
      })
    console.log(this.bookedSeats)
  }

  isBooked(no:number){
    //console.log(no)
      return this.bookedSeats.includes(no);
  }

  confirmSeats() {
    // code to store the selected seats in the bookedSeats array
    localStorage.setItem('bookedSeats', JSON.stringify(this.mySeats))
    this.router.navigate(['/flights/add-passengers'])
  }

  getCheckboxValues(data) {
    
      console.log(data)
      console.log("h")
    
      // Pushing the object into array
      this.mySeats.push(data)

    console.log(this.mySeats)
    //Duplicates the obj if we uncheck it
    //How to remove the value from array if we uncheck it
  }

}
