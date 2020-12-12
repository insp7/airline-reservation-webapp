import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { User } from './User'

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

const URL = 'http://localhost:8080/airlinesReservationRESTApp_war_exploded/users';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  
  constructor(private http: HttpClient) { }

  getUsers() {
    // get users
  }

  saveUser(user: User): void {
    this.http.post<User>(URL, user, httpOptions)
      .subscribe((data: User) => {
        console.log('user is ', user);
      }, );
  }
}
