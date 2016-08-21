package com.pablo.springCRUD1.service;

import com.pablo.springCRUD1.model.Car;

import java.util.List;

/**
 * Created by Pablo on 17.08.2016.
 */
public interface CarService {
    void addCar(Car c);
    void updateCar(Car c);
    List<Car> listCars();
    Car getCarById(int id);
    void removeCar(int id);
}
