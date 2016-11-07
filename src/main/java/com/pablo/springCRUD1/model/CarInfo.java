package com.pablo.springCRUD1.model;

import com.pablo.springCRUD1.Entity.Car;
import com.pablo.springCRUD1.service.washLogic.CostCounter;

/**
 * Created by Pablo on 29.09.2016.
 */
public class CarInfo {

    private Car car;
    private double cost;
    private boolean complete;
    private String station;

    public CarInfo(Car car) {
        CostCounter counter = new CostCounter();
        this.car = car;
        this.cost = counter.getCarCost(car);
        this.station = counter.getStation(car);
    }
    public Car getCar() {
        return car;
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
