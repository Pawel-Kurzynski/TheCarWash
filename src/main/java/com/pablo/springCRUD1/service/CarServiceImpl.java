package com.pablo.springCRUD1.service;

import com.pablo.springCRUD1.dao.CarDAO;
import com.pablo.springCRUD1.model.Car;
import com.pablo.springCRUD1.model.Client;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pablo on 17.08.2016.
 */
public class CarServiceImpl implements CarService {

    private CarDAO carDAO;

    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    @Transactional
    public void addCar(Car car, Client client) {
        this.carDAO.addCar(car, client);
    }

    @Override
    @Transactional
    public void updateCar(Car c) {
        this.carDAO.updateCar(c);
    }

    @Override
    @Transactional
    public List<Car> listCars(int clientID) {
        return this.carDAO.listCars(clientID);
    }

    @Override
    @Transactional
    public Car getCarById(int id) {
        return carDAO.getCarById(id);
    }

    @Override
    @Transactional
    public void removeCar(int id) {
        carDAO.removeCar(id);
    }
}
