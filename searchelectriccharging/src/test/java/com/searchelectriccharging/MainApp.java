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
