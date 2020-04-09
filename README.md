# Seats reservation
The base for an app to reserve seats for theatre, cinema or transport. Made to learn Spring Data repositories (Spring Boot, Java, Spring Data, H2) 

There is H2 database with pre-generated schema and data used, you can find them in resources directory. 
Data was generated from dbgenerator.Main so you can recreate it by running this class, it will rewrite data.sql at resources. There is one line in Controller which help pre-generated data to work too, it should be removed on real projects without test data.

The main wed-address of the project is http://localhost:8080/events here you can find the list of events. Events will be randomly created in 30 following days from today's date. The first load can be slow because the reservation for each event will be created (only on test data).

![Preview 1](https://github.com/Hexronimo/seatsreservation/raw/master/prev01.png)
![Preview 2](https://github.com/Hexronimo/seatsreservation/raw/master/prev02.png)
![Preview 3](https://github.com/Hexronimo/seatsreservation/raw/master/prev03.png)
