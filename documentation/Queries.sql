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