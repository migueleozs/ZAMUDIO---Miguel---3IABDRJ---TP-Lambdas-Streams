package exo;

import models.Trip;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

public class Partie1 {

    static Predicate<Trip> longTrip = trip -> trip.distanceKm() > 10;
    static Predicate<Trip> expensiveTrip = trip -> trip.price() > 20;
    static Predicate<Trip> badTrip = trip -> trip.rating() < 3;
    static Predicate<Trip> recentTrip = trip -> {
        LocalDateTime tripDate = trip.startTime();
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);

        if (tripDate.isEqual(today) || tripDate.isEqual(yesterday) ) {
            return true;
        }
        else {
            return false;
        }
    };

    public static List<Trip> longAndExpensiveTrips(List<Trip> trips) {
        // distance > 10km et prix > 20€
        return trips.stream()
                .filter(longTrip.and(expensiveTrip))
                .toList();
    }

    public static List<Trip> badTrips(List<Trip> trips) {
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
        List<Trip> lAndEtrips = longAndExpensiveTrips(trips);
        List<Trip> badTrips = badTrips(trips);
        List<Trip> recentTrips = recentTrips(trips);

        System.out.println("long and expensive trips in " + lAndEtrips);
        System.out.println("bad trips in " + badTrips);
        System.out.println("recent trips in " + recentTrips);
    }

}
