package com.pablo.springCRUD1.service;

import com.pablo.springCRUD1.Entity.Car;
import com.pablo.springCRUD1.model.CarInfo;

import java.util.List;

/**
 * Created by Pablo on 17.08.2016.
 */
public interface CarService {
    void addCar(Car car);
    void updateCar(Car car);
    List<CarInfo> listCars(int clientID);
    CarInfo getCarById(int id);
    void removeCar(int id);
}
