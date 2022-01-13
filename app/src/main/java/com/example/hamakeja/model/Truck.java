package com.example.hamakeja.model;

public class Truck {
    private String truckId;
    private String truckNumber;
    private String parkedLocation;
    private String imageName;
    private String contactNumber;
    private String overallSize;
    private String carryingCapacity;

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getParkedLocation() {
        return parkedLocation;
    }

    public void setParkedLocation(String parkedLocation) {
        this.parkedLocation = parkedLocation;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getOverallSize() {
        return overallSize;
    }

    public void setOverallSize(String overallSize) {
        this.overallSize = overallSize;
    }

    public String getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(String carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
}

