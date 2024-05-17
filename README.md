# AirlinesReservationApp
Airline Reservation is a web application which provides a user-friendly User Interface and an easy efficient way to search, book and cancel flight tickets. This application is currently working for a single airline company and only for domestic flights.

![AltText](https://github.com/insp7/airline-reservation-webapp/blob/master/documentation/diagrams/Airlines%20Reservation%20ERD%20White%20Background%20(for%20documentation).png)

### Functionalities:

1. User registration & Authentication.
2. User can search for flights.
3. User can check for the availability of tickets of a flight, flight schedule.
4. User can book a ticket for a particular flight of any class. (receipt generated)
5. User can see details for the booked flight by entering booking number/Passenger name record(PNR, which is a code of 6 alphanumeric characters)
6. User can cancel booked ticket for a particular flight before 3 hours from the departure of flight.
7. After cancellation of a ticket, system also calculates the amount to be return to the user after deductions.
8. Admin can add or delete a flight.
9. Logging for each issuance/cancellation of tickets should be made in the system.
10. Payment.


#### TO DO:
1. Secure the REST api using spring security.
1. Create a file which lists out all the endpoints of this api and their purpose.
2. Create a documentation file.
