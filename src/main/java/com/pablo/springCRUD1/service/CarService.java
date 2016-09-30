package com.pablo.springCRUD1.service;

import com.pablo.springCRUD1.model.Car;
import com.pablo.springCRUD1.model.Client;

import java.util.List;

/**
 * Created by Pablo on 17.08.2016.
 */
public interface CarService {
    void addCar(Car car);
    void updateCar(Car car);
    List<Car> listCars(int clientID);
    Car getCarById(int id);
    void removeCar(int id);
}
