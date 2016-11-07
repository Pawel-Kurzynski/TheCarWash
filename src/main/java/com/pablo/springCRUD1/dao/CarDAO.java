package com.pablo.springCRUD1.dao;

import com.pablo.springCRUD1.Entity.Car;

import java.util.List;

/**
 * Created by Pablo on 30.07.2016.
 */
public interface CarDAO {
    void addCar(Car car);
    void updateCar(Car c);
    List<Car> listCars(int clientID);
    Car getCarById(int id);
    void removeCar(int id);
}
