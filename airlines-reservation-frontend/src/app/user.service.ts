import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { User } from './User';
import { AuthenticationDetails } from './authentication-details';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

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

  getUsers(): Observable<any> {
    return this.http.get(URL)
  }

  saveUser(user: User): void {
    this.http.post<User>(URL, user, httpOptions)
      .subscribe(() => {
        console.log('user is ', user);
        this.router.navigate(['/login']);
      }, );
  }

  authenticateUser(userDetails: AuthenticationDetails): Observable<any> {
    return this.http.post(AUTH_URL, userDetails, httpOptions)
  }
}
