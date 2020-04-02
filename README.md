# taxi-travel-ticketing-system
This application is to book taxi and print travel ticket

## Language
- [Java][11]

## Required dependencies to run the application
- [Maven][3+]

## Run Instructions
1) To run build application, use maven command
   mvn clean install

2) To run unit tests, use surefire plugin command
   mvn surefire:test
   You can check surefire report under target directory.
   
3) To run application
   run main class "TaxiTravelTicketingSystem"
   
## Sample Example

Input:

TravelRequest travelRequest = new TravelRequest("PUNE", "NASHIK", 1);

Output:

<pre>
Taxi Ticket
-----------
Source: PUNE
Destination: NASHIK
Kms: 200
No. of travellers = 1 
Total = 1250 INR

</pre>


