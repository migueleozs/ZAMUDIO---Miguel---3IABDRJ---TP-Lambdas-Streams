package exo;

import models.Trip;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Partie1 {

    static Predicate<Trip> longTrip = trip -> trip.distanceKm() > 10;
    static Predicate<Trip> expensiveTrip = trip -> trip.price() > 20;
    static Predicate<Trip> badTrip = trip -> trip.rating() < 3;
    static Predicate<Trip> recentTrip = trip -> {
        LocalDate tripDate = trip.startTime().toLocalDate();
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        if (tripDate.isEqual(today) || tripDate.isEqual(yesterday)) return true;
        else return false;
    };

    public static List<Trip> longAndExpensiveTrips(List<Trip> trips) {
        // distance > 10km et prix > 20€
        return trips.stream()
                .filter(longTrip.and(expensiveTrip))
                .toList();
    }

    public static List<Trip> badTrips(List<Trip> trips) {
        // rating < 3
        return trips.stream()
                .filter(badTrip)
                .toList();
    }

    public static List<Trip> recentTrips(List<Trip> trips) {
        // aujourd’hui ou hier
        return trips.stream()
                .filter(recentTrip)
                .toList();
    }


    public static void run(List<Trip> trips) {
        System.out.println("Long and expensive trips: " + longAndExpensiveTrips(trips));
        System.out.println("Bad trips: " + badTrips(trips));
        System.out.println("Recent trips: " + recentTrips(trips));
    }

}
