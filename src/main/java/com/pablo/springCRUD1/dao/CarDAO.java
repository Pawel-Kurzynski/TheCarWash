package com.pablo.springCRUD1.dao;

import com.pablo.springCRUD1.model.Car;

import java.util.List;

/**
 * Created by Pablo on 30.07.2016.
 */
public interface CarDAO {
    void addCar(Car c);
    void updateEmployee(Car c);
    List<Car> listEmployee();
    Car getCarById(int id);
    void removeCar(int id);
}
