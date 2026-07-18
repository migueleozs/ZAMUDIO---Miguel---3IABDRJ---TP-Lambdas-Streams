import factory.TripFactory;
import models.Trip;
import exo.*;

void main() {
    //List<Trip> trips = TripFactory.generateTripsParallel(10000000);

    List<Trip> trips = TripFactory.generateTrips(10);

    Partie1.run(trips);
    Partie2.run(trips);
    Partie3.run(trips);
    Partie4.run(trips);
}