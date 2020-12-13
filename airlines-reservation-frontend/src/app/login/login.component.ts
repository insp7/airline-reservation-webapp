import { Component, OnInit } from '@angular/core';
import { AuthenticationDetails } from 'app/authentication-details';
import { UserService } from "../user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userDetails = new AuthenticationDetails();

  constructor(private userService: UserService) { }
  ngOnInit(): void { }

  authenticateUser() {
    this.userService.authenticateUser(this.userDetails);
  }
}
