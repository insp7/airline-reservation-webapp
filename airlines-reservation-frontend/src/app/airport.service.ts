import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

import { Airport } from './airport';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

const URL = 'http://localhost:8080/airlinesReservationRESTApp_war_exploded/airports'

@Injectable({
  providedIn: 'root'
})
export class AirportService {

  constructor(private http: HttpClient, private router: Router) { }

  getAirports(): Observable<any> {
    return this.http.get(URL);
  }

  saveAirport(airport: Airport): Observable<any> {
    return this.http.post<Airport>(URL, airport, httpOptions)
  }

  getAirportById(id: number): Observable<any> {
    return this.http.get(URL + '/' + id);
  }

  updateAirport(airport: Airport): Observable<any> {
    return this.http.put<Airport>(URL, airport);
  }

  deleteAirport(id: number) {
    return this.http.delete(URL + '/' + id)
  }
}