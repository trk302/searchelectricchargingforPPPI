package com.searchelectriccharging;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RoutePlannerTest {
    @Test
    void testFindNearestStation() {
        Station station1 = new Station("Station 1", "Address 1", 10.0, 4);
        Station station2 = new Station("Station 2", "Address 2", 12.5, 2);

        List<Station> stations = new ArrayList<>();
        stations.add(station1);
        stations.add(station2);

        RoutePlanner routePlanner = new RoutePlanner(stations);

        Station nearestStation = routePlanner.findNearestStation();

        Assertions.assertNotNull(nearestStation);
        Assertions.assertEquals("Station 1", nearestStation.getName());
    }

    @Test
    void testGetAvailableStations() {
        Station station1 = new Station("Station 1", "Address 1", 10.0, 4);
        Station station2 = new Station("Station 2", "Address 2", 12.5, 2);

        List<Station> stations = new ArrayList<>();
        stations.add(station1);
        stations.add(station2);

        RoutePlanner routePlanner = new RoutePlanner(stations);

        List<Station> availableStations = routePlanner.getAvailableStations();

        Assertions.assertEquals(2, availableStations.size());
        Assertions.assertEquals("Station 1", availableStations.get(0).getName());
        Assertions.assertEquals("Station 2", availableStations.get(1).getName());
    }
}

