import { Component, OnInit } from '@angular/core';

declare const $: any;
declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: '/flights', title: 'Flights',  icon: 'flight', class: '' },
    { path: '/reservations', title: 'Reservations',  icon:'bookmarks', class: '' },
    { path: '/airports', title: 'Airports',  icon:'place', class: '' },
    { path: '/flights-search', title: 'Search Flights',  icon:'search', class: '' },
    { path: '/payment', title: 'Payment',  icon:'payment', class: '' },
    { path: '/reservations-user', title: 'My Trips',  icon:'flight_takeoff', class: '' },
];

export const USERROUTES: RouteInfo[] = [
  { path: '/flights-search', title: 'Search Flights',  icon:'search', class: '' },
  { path: '/reservations-user', title: 'My Trips',  icon:'flight_takeoff', class: '' },
  { path: '/payment', title: 'Payment',  icon:'payment', class: '' },
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    if(localStorage.getItem('isAdmin') == '1'){ // is admin
      this.menuItems = ROUTES.filter(menuItem => menuItem);
    }else{
      this.menuItems = USERROUTES.filter(menuItem => menuItem);
    }
    
  }
  isMobileMenu() {
      if ($(window).width() > 991) {
          return false;
      }
      return true;
  };
}
