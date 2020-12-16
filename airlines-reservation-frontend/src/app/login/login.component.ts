import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationDetails } from 'app/authentication-details';
import { User } from 'app/user';
import { UserService } from "../user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userDetails = new AuthenticationDetails();
  user: User
  public invalidDetails = false;

  constructor(private userService: UserService, private router: Router) { }
  ngOnInit(): void { }

  authenticateUser() {
    this.userService.authenticateUser(this.userDetails)
      .subscribe((data: User) => {
        if(data == null) {
          this.invalidDetails = true;
          console.log('ERR WRONG USER');
        } else {
          console.log('User Details :', data);
          if(data.isAdmin == 1) { 
            // this.router.navigate(['/'])
            console.log("Admin")
            localStorage.setItem('isAdmin', '1')
            // localStorage.setItem('userId', '' + data.id)
          } else {
            localStorage.setItem('isAdmin', '0')
            // this.router.navigate(['/']);
          }
          console.log('User id is ', data.id)
          localStorage.setItem('userId', '' + data.id)
          this.router.navigate(['/flights-search'])
        }
        // this.router.navigate(['/']);
      }, );
  }
}
