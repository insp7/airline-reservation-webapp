import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Passenger } from 'app/passenger'
import { Router } from '@angular/router';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

const URL = "http://localhost:8080/airlinesReservationRESTApp_war_exploded/passengers"

@Injectable({
  providedIn: 'root'
})
export class PassengerService {

  constructor(private http: HttpClient, private router: Router) { }

  savePassengers(passengers: Passenger[]): void {
    this.http.post<Passenger[]>(URL + '/multiple', passengers, httpOptions)
      .subscribe(() => {
        console.log('user is ', passengers);
        // this.router.navigate(['/login']);
      }, );
  }

}
