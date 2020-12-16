import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reservation } from 'app/reservation';
import { ReservationService } from 'app/reservation.service';
import { User } from 'app/user';
import { UserService } from 'app/user.service';

@Component({
  selector: 'app-view-reservations',
  templateUrl: './view-reservations.component.html',
  styleUrls: ['./view-reservations.component.css']
})
export class ViewReservationsComponent implements OnInit {
  reservations: Reservation[]
  users: User[]
  constructor(private reservationService: ReservationService, private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.userService.getUsers()
      .subscribe((user: User[]) => {
        this.users = user
      })
    this.getReservations();
  }

  getReservations() {
    this.reservationService.getReservations()
      .subscribe((reservations: Reservation[]) => {
        this.reservations = reservations
        console.log(reservations)
      })
  }

  getUserName(id: number) {
    let name = 'NA';
    this.users.forEach(user => {
      if(user.id == id)
        name = user.firstName + ' ' + user.lastName
    })
    return name;
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
