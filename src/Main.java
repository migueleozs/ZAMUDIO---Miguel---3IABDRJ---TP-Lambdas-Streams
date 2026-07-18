import factory.TripFactory;
import models.Trip;
import exo.*;

void main() {
    // List<Trip> trips = TripFactory.generateTrips(10000000);

    List<Trip> trips = TripFactory.generateTrips(3);

    Partie1.run(trips);
    Partie2.run(trips);


    // appeler les méthodes des exos ici
    // pour tester si ça marche bien, générer une liste de 10 éléments et afficher le résultat
}