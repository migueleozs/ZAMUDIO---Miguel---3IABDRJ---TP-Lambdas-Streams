package exo;

import models.Trip;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Partie3 {

    static Comparator<Trip> byPrice = Comparator.comparingDouble(trip -> trip.price());
    static Comparator<Trip> byRating = Comparator.comparingDouble(trip -> trip.rating());


    static public List<Trip> top10ExpensiveTrips(List<Trip> trips) {
        //Top 10 des trajets les plus chers
        List<Trip> topTrips = trips.stream()
                .sorted(byPrice.reversed())
                .limit(2)
                .toList();
        return topTrips;
    }

    static public Optional<Trip> bestTrip(List<Trip> trips) {
        //Trajet avec la meilleure note
        Optional<Trip> topTrip = trips.stream()
                .max(byRating);
        return topTrip;
    }

    public static void run(List<Trip> trips) {
        System.out.println("Top 10 Expensive trips:  " + top10ExpensiveTrips(trips));
        System.out.println("Best trip: " + bestTrip(trips));
    }

}
