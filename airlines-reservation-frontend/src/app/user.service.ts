import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { User } from './User';
import { AuthenticationDetails } from './authentication-details';
import { Router } from '@angular/router';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

const URL = 'http://localhost:8080/airlinesReservationRESTApp_war_exploded/users';
const AUTH_URL = 'http://localhost:8080/airlinesReservationRESTApp_war_exploded/users/authenticate';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient, private router: Router) { }

  getUsers() {
    // get users
  }

  saveUser(user: User): void {
    this.http.post<User>(URL, user, httpOptions)
      .subscribe(() => {
        console.log('user is ', user);
        this.router.navigate(['/login']);
      }, );
  }

  authenticateUser(userDetails: AuthenticationDetails): void {
    this.http.post(AUTH_URL, userDetails, httpOptions)
      .subscribe((data: User) => {
        if(data == null) {
          console.log('ERR WRONG USER');
        } else {
          console.log('User Details :', data);
          if(data.isAdmin == 1) { 
            // this.router.navigate(['/'])
            console.log("Admin");
            // localStorage.setItem('userId', '' + data.id)
          } else {
            this.router.navigate(['/']);
          }
        }
        // this.router.navigate(['/']);
      }, );
  }
}
