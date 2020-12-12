import { Component, OnInit } from '@angular/core';
import { User } from 'app/user';
import { UserService } from "../user.service";

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent implements OnInit {
  user: User = new User();

  constructor(private userService: UserService) { }
  ngOnInit(): void { }

  registerUser(): void {
    this.userService.saveUser(this.user);
  }
}
