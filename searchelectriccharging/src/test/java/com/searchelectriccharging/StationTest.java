package com.searchelectriccharging;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class StationTest {
    @Test
    void testStationInitialization() {
        Station station = new Station("Station 1", "Address 1", 10.0, 4);

        Assertions.assertEquals("Station 1", station.getName());
        Assertions.assertEquals("Address 1", station.getAddress());
        Assertions.assertEquals(10.0, station.getChargeCost());
        Assertions.assertEquals(4, station.getNumPorts());

        List<String> portStatuses = station.getPortStatuses();
        Assertions.assertEquals(4, portStatuses.size());
        Assertions.assertEquals("вільний", portStatuses.get(0));
        Assertions.assertEquals("вільний", portStatuses.get(1));
        Assertions.assertEquals("вільний", portStatuses.get(2));
        Assertions.assertEquals("вільний", portStatuses.get(3));
    }
}

