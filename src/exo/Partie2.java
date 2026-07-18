package exo;


import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Partie2 {

    static Function<Trip, String> tripCity = trip -> trip.city();
    static Function<Trip, String> tripDriver = trip -> trip.driverId();
    static ToDoubleFunction<Trip> tripPrice = trip -> trip.price();
    static ToDoubleFunction<Trip> tripDuration = trip -> trip.durationMin();

    static public Map<String, Long> countByCity(List<Trip> trips) {
        //Nombre de trajets par ville
        return trips.stream()
                .collect(Collectors.groupingBy(tripCity, Collectors.counting()));
    }

    static public Map<String, Double> revenueByDriver(List<Trip> trips) {
        //Revenu total par chauffeur
        return trips.stream()
                .collect(Collectors.groupingBy(tripDriver, Collectors.summingDouble(tripPrice)));
    }

    static public Map<String, Double> avgDurationByCity(List<Trip> trips) {
        // durée moyenne par ville
        return trips.stream()
                .collect(Collectors.groupingBy(tripCity, Collectors.averagingDouble(tripDuration)));
    }

    public static void run(List<Trip> trips) {
        System.out.println("Trips by city:  " + countByCity(trips));
        System.out.println("Revenue by driver: " + revenueByDriver(trips));
        System.out.println("Average duration by city: " + avgDurationByCity(trips));
    }


}
