package com.searchelectriccharging;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Station> stations = createStations();

        RoutePlanner routePlanner = new RoutePlanner(stations);

        Station nearestStation = routePlanner.findNearestStation();
        if (nearestStation != null) {
            System.out.println("Найближча станція: " + nearestStation.getName());
        } else {
            System.out.println("Немає доступних станцій.");
        }

        List<Station> availableStations = routePlanner.getAvailableStations();
        if (!availableStations.isEmpty()) {
            System.out.println("Вільні станції:");
            for (Station station : availableStations) {
                System.out.println(station.getName());
            }
        } else {
            System.out.println("Немає доступних вільних станцій.");
        }

        LanguageManager languageManager = new LanguageManager();
        languageManager.changeLanguage("en");
        String currentLanguage = languageManager.getCurrentLanguage();
        System.out.println("Поточна мова: " + currentLanguage);
    }

    private static List<Station> createStations() {
        Station station1 = new Station("Station 1", "Address 1", 10.0, 4);
        Station station2 = new Station("Station 2", "Address 2", 12.5, 2);

        List<Station> stations = new ArrayList<>();
        stations.add(station1);
        stations.add(station2);

        return stations;
    }
}
class Station {
    private String name;
    private String address;
    private double chargeCost;
    private int numPorts;
    private List<String> portStatuses;

    public Station(String name, String address, double chargeCost, int numPorts) {
        this.name = name;
        this.address = address;
        this.chargeCost = chargeCost;
        this.numPorts = numPorts;
        this.portStatuses = new ArrayList<>();
        initializePortStatuses();
    }

    private void initializePortStatuses() {
        for (int i = 0; i < numPorts; i++) {
            portStatuses.add("вільний");
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getChargeCost() {
        return chargeCost;
    }

    public int getNumPorts() {
        return numPorts;
    }

    public List<String> getPortStatuses() {
        return portStatuses;
    }
}
class RoutePlanner {
    private List<Station> stations;

    public RoutePlanner(List<Station> stations) {
        this.stations = stations;
    }

    public Station findNearestStation() {
        Station nearestStation = null;
        double minDistance = Double.MAX_VALUE;
        for (Station station : stations) {
            double distance = calculateDistance(station);
            if (distance < minDistance) {
                minDistance = distance;
                nearestStation = station;
            }
        }
        return nearestStation;
    }

    private double calculateDistance(Station station) {
        double x1 = 0.0; // Координати поточного розташування користувача
        double y1 = 0.0;
        double x2 = 0.0; // Координати станції
        double y2 = 0.0;
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }

    public List<Station> getAvailableStations() {
        List<Station> availableStations = new ArrayList<>();

        for (Station station : stations) {
            if (isStationAvailable(station)) {
                availableStations.add(station);
            }
        }
        return availableStations;
    }

    private boolean isStationAvailable(Station station) {
        List<String> portStatuses = station.getPortStatuses();
        for (String status : portStatuses) {
            if (status.equals("вільний")) {
                return true;
            }
        }
        return false;
    }
}
class LanguageManager {
    private String currentLanguage;

    public void changeLanguage(String language) {
        this.currentLanguage = language;
    }

    public String getCurrentLanguage() {
        return currentLanguage;
    }
}
