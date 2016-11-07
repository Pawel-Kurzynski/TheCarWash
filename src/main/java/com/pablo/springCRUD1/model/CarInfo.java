package com.pablo.springCRUD1.model;

import com.pablo.springCRUD1.Entity.Car;
/**
 * Created by Pablo on 29.09.2016.
 */
public class CarInfo {

    private int clientID;
    private String model;
    private double width;
    private double height;
    private boolean waxing = false;
    private String plateNumber;
    private double cost;
    private boolean complete;
    private String station;

    public CarInfo(Car car) {
        this.clientID = car.getClient().getId();
        this.model = car.getModel();
        this.width = car.getWidth();
        this.height = car.getHeight();
        this.waxing = car.isWaxing();
        this.plateNumber = car.getPlateNumber();
    }

    public int getClientID() {
        return clientID;
    }

    public String getModel() {
        return model;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public boolean isWaxing() {
        return waxing;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
