package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Partie4 {

    static Function<Trip, String> tripCity = trip -> trip.city();
    static ToDoubleFunction<Trip> tripPrice = trip -> trip.price();
    static Predicate<Trip> expensiveTrip = trip -> trip.price() > 30;
    static Predicate<Trip> goodTrip = trip -> trip.rating() > 4;

    static double totalRevenueSequential(List<Trip> trips) {
        return  trips.stream()
                .mapToDouble(tripPrice)
                .sum();
    }

    static public double totalRevenueParallel(List<Trip> trips) {
        return trips.parallelStream()
                .mapToDouble(tripPrice)
                .sum();
    }

    static public Map<String, Long> countByCityParallel(List<Trip> trips) {
        return trips.stream()
                .parallel()
                .collect(Collectors.groupingByConcurrent(tripCity, Collectors.counting()));
    }

    static public List<Trip> premiumTripsParallel(List<Trip> trips) {
        // prix > 30 & rating > 4
        return trips.parallelStream()
                .filter(expensiveTrip.and(goodTrip))
                .collect(Collectors.toList());
    }

    public static void run(List<Trip> trips) {
        System.out.println("total revenue Sequential: " + totalRevenueSequential(trips));
        System.out.println("total revenue Parallel: " + totalRevenueParallel(trips));
        System.out.println("Count by City Parallel: " + countByCityParallel(trips));
        System.out.println("Premium trips: " + premiumTripsParallel(trips));
    }

}
