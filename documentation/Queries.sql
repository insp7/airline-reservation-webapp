# QUERIES: 

# Fetch available flights as per user's requirements
SELECT * FROM flights WHERE source = :source AND destination = :destination AND departure_date LIKE ':date-string%' AND cabin_class = :cabin_class AND capacity > :capacity;
# Ex.
SELECT * FROM flights WHERE flights.source = 1 AND flights.destination = 2 AND flights.departure_date LIKE '2020-12-15%' AND flights.cabin_class = 1 AND flights.capacity > 4;

# Query to create tables
CREATE TABLE users(id NUMBER(11) PRIMARY KEY, firstName VARCHAR2(100), lastName VARCHAR2(100), email VARCHAR2(100), password VARCHAR2(100), gender VARCHAR2(1), dateOfBirth VARCHAR2(30), contactNo VARCHAR2(10), isAdmin NUMBER(1));
CREATE TABLE flights(id NUMBER(11) PRIMARY KEY, source NUMBER(11), destination NUMBER(11), departureDate VARCHAR2(50), arrivalDate VARCHAR2(50), capacity NUMBER(2), cabinClass NUMBER(1), fare NUMBER(11));
CREATE TABLE airports(id NUMBER(11) PRIMARY KEY, name VARCHAR2(100), city VARCHAR2(100), state VARCHAR2(100));
CREATE TABLE reservations(id NUMBER(11) PRIMARY KEY, userId NUMBER(11), flightId NUMBER(11), cabinClass VARCHAR2(1), totalFare NUMBER(11), returnedAmount NUMBER(11), isCancelled NUMBER(11), createdAt VARCHAR2(30));

# GET reserved seats for a particular flight
SELECT seatNo FROM passengers WHERE reservationID IN (SELECT id FROM reservations WHERE flightId = 7);
SELECT seatNo FROM passengers p INNER JOIN reservations r ON p.reservationID = r.id; 	

# QUERIES WHEN USER cancels a flight
update the flights table and increment the capacity according to the freed seats, and then delete from passengers:
DELETE FROM passengers WHERE reservationID IN (SELECT id FROM reservations WHERE isCancelled = 1);


# DML queries for testing
INSERT INTO reservations(id, userId, flightId, cabinClass, totalFare) VALUES(1, 7, 16, '2', 20000);
INSERT INTO reservations(id, userId, flightId, cabinClass, totalFare) VALUES(2, 16, 17, '1', 200002);

INSERT INTO passengers(id, reservationID, seatNo, firstName, lastName, gender, dateOfBirth, passengerType) VALUES(1, 1, 16, 'Aniket', 'Konkar', 1, '16-11-1998', 1);
INSERT INTO passengers(id, reservationID, seatNo, firstName, lastName, gender, dateOfBirth, passengerType) VALUES(2, 1, 17, 'ABC', 'Konkar', 1, '26-11-1998', 2);
INSERT INTO passengers(id, reservationID, seatNo, firstName, lastName, gender, dateOfBirth, passengerType) VALUES(3, 1, 18, 'XYZ', 'Konkar', 1, '2-11-1998', 3);
INSERT INTO passengers(id, reservationID, seatNo, firstName, lastName, gender, dateOfBirth, passengerType) VALUES(4, 1, 19, 'LOL', 'Konkar', 1, '4-11-1998', 1);
INSERT INTO passengers(id, reservationID, seatNo, firstName, lastName, gender, dateOfBirth, passengerType) VALUES(5, 2, 19, 'LOL2', 'surname1', 2, '5-11-1998', 1);
INSERT INTO passengers(id, reservationID, seatNo, firstName, lastName, gender, dateOfBirth, passengerType) VALUES(6, 2, 20, 'LOL3', 'surname2', 2, '6-11-1998', 1);
INSERT INTO passengers(id, reservationID, seatNo, firstName, lastName, gender, dateOfBirth, passengerType) VALUES(7, 2, 21, 'LOL5', 'surname3', 2, '7-11-1998', 1);


# Very Rough flow after user selects flight, selects seats and enters passengers' details [WILL WRITE EXPLANATION IN A BETTER WAY LATER]
reservations table
user id => 15, flight id => 16, base fare(can calculate total fare by using this) (ex.)

passengers table (get the reservation id which is inserted in the reservations table)
21 bla gender dob passengertype
22 bla gender dob passengertype
23 bla gender dob passengertype