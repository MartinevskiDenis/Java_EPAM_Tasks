package by.epam.lab3.service;

import by.epam.lab3.entity.Aircraft;
import by.epam.lab3.entity.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class Filter {
    private static final Logger log = LogManager.getLogger();

    public static boolean isAircraftsWithCapacity(Optional<ArrayList<Aircraft>> aircrafts, int capacity) throws NullPointerException {
        aircrafts.orElseThrow(NullPointerException::new);
        return aircrafts.get().stream()
                .peek(log::info)
                .anyMatch(item -> item.getCapacity() > capacity);
    }

    public static Optional<Aircraft> getAircraftMaxCapacity(Optional<ArrayList<Aircraft>> aircrafts) throws NullPointerException {
        aircrafts.orElseThrow(NullPointerException::new);
        return aircrafts.get().stream()
                .max(Comparator.comparing(Aircraft::getCapacity));
    }

    public static Optional<Aircraft> getAircraftMinCapacity(Optional<ArrayList<Aircraft>> aircrafts) throws NullPointerException {
        aircrafts.orElseThrow(NullPointerException::new);
        return aircrafts.get().stream()
                .min(Comparator.comparing(Aircraft::getCapacity));
    }

    public static ArrayList<Aircraft> getAircraftsOneOwner(Optional<ArrayList<Aircraft>> aircrafts) throws NullPointerException {
        aircrafts.orElseThrow(NullPointerException::new);
        return aircrafts.get().stream()
                .filter(item -> item.getStores().size() == 1)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Aircraft> getAircraftsOneOwnerParallel(Optional<ArrayList<Aircraft>> aircrafts) throws NullPointerException {
        aircrafts.orElseThrow(NullPointerException::new);
        return aircrafts.get().parallelStream()
                .filter(item -> item.getStores().size() == 1)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Aircraft> getSortedByPrice(Optional<ArrayList<Aircraft>> aircrafts) throws NullPointerException {
        aircrafts.orElseThrow(NullPointerException::new);
        return aircrafts.get().stream()
                .sorted(Comparator.comparing(Aircraft::getPrice))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Aircraft> getSortedByCapacity(Optional<ArrayList<Aircraft>> aircrafts) throws NullPointerException {
        aircrafts.orElseThrow(NullPointerException::new);
        return aircrafts.get().stream()
                .sorted(Comparator.comparing(Aircraft::getCapacity))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Owner> getOwners(Optional<ArrayList<Aircraft>> aircrafts) throws NullPointerException {
        aircrafts.orElseThrow(NullPointerException::new);
        return aircrafts.get().stream()
                .peek(log::info)
                .flatMap(item -> item.getStores().stream())
                .peek(log::info)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Owner> getOwnersDistinct(Optional<ArrayList<Aircraft>> aircrafts) throws NullPointerException {
        aircrafts.orElseThrow(NullPointerException::new);
        return aircrafts.get().stream()
                .flatMap(item -> item.getStores().stream())
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void printOwners(Optional<ArrayList<Aircraft>> aircrafts) throws NullPointerException {
        aircrafts.orElseThrow(NullPointerException::new);
        getOwnersDistinct(aircrafts).forEach(System.out::println);
    }
}