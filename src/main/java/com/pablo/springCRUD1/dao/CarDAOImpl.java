package com.pablo.springCRUD1.dao;

import com.pablo.springCRUD1.model.Car;
import com.pablo.springCRUD1.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Pablo on 03.08.2016.
 */
public class CarDAOImpl implements CarDAO{

    private static final Logger logger = LoggerFactory.getLogger(CarDAOImpl.class);
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addCar(Car c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        logger.info("Car saved successfully, Car details: " + c);
    }

    @Override
    public void updateCar(Car c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        logger.info("Car updated successfully, Car details: " + c);
    }

    @Override
    public List<Car> listCars() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Car> carList = session.createQuery("from Car").list();
        for (Car c: carList){
            logger.info("Car List:: " + c);
        }
        return carList;
    }

    @Override
    public Car getCarById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Car c = (Car) session.load(Car.class, new Integer(id));
        logger.info("Car loaded successfully, Car details: " + c);
        return c;
    }

    @Override
    public void removeCar(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Car c = (Car) session.load(Car.class, new Integer(id));
        if (c != null){
            session.delete(c);
        }
        logger.info("Car deleted successfully, Car details: " + c);
    }
}
