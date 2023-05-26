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
