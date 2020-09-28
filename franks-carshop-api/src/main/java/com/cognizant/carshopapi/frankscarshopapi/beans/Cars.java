package com.cognizant.carshopapi.frankscarshopapi.beans;

import java.util.List;

public class Cars {
    private String location;
    private List<Vehicle> vehicles = null;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
