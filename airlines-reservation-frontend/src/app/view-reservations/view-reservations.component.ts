import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reservation } from 'app/reservation';
import { ReservationService } from 'app/reservation.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-view-reservations',
  templateUrl: './view-reservations.component.html',
  styleUrls: ['./view-reservations.component.css']
})
export class ViewReservationsComponent implements OnInit {
  reservations: Reservation[]

  constructor(private reservationService: ReservationService, private router: Router) { }

  ngOnInit(): void {
    this.getReservations();
  }

  getReservations() {
    this.reservationService.getReservations()
      .subscribe((reservations: Reservation[]) => {
        this.reservations = reservations
        console.log(reservations)
      })
  }
}
