import { Injectable } from '@angular/core'
import { HttpHeaders } from '@angular/common/http'
import { HttpClient } from '@angular/common/http'
import { Router } from '@angular/router'

import { Reservation } from './reservation'
import { Observable } from 'rxjs'

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

const URL = 'http://localhost:8080/airlinesReservationRESTApp_war_exploded/reservations'

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient, private router: Router) { }

  getReservations(): Observable<any> {
    console.log('coming here')
    return this.http.get(URL)
  }

  makeReservation(reservation: Reservation): Observable<any> {
    return this.http.post(URL, reservation, httpOptions)
  }
}
