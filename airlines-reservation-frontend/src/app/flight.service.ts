import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

import { Flight } from './flight';
import { Observable } from 'rxjs';
import { FlightPreference } from './flight-preference';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

const URL = 'http://localhost:8080/airlinesReservationRESTApp_war_exploded/flights'

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  constructor(private http: HttpClient, private router: Router) { }

  getFlights(): Observable<any> {
    return this.http.get(URL)
  }

  saveFlight(flight: Flight): Observable<any> {
    return this.http.post<Flight>(URL, flight, httpOptions)
  }

  getFlightById(id: number): Observable<any> {
    return this.http.get(URL + '/' + id)
  }

  updateFlight(flight: Flight): Observable<any> {
    return this.http.put<Flight>(URL, flight)
  }

  deleteFlight(id: number) {
    return this.http.delete(URL + '/' + id)
  }

  searchFlights(flightPreference: FlightPreference): Observable<any> {
    return this.http.post<Flight[]>('http://localhost:8080/airlinesReservationRESTApp_war_exploded/flights/search', flightPreference, httpOptions)
  }

  getBookedSeats(flightId: number): Observable<any> {
    return this.http.get(URL + '/reserved-seats/' + flightId)
  }
}
