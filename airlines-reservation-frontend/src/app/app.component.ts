import { Component} from '@angular/core';
import { from } from 'rxjs';
import { CommonModule } from '@angular/common';  

import {Router} from '@angular/router'
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor( private router: Router) { }


  readonly ROOT_URL = 'http://localhost:8080/airlinesReservationRESTApp_war_exploded/';

  isStartPage(){
    if(this.router.url == '/login' || this.router.url == '/register')
      return false;
    return true;
  }
}
