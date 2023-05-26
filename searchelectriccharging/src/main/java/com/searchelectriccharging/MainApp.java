package com.searchelectriccharging;

import java.util.ArrayList;
import java.util.List;

public class MainApp 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
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
