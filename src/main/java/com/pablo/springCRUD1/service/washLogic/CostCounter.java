package com.pablo.springCRUD1.service.washLogic;

import com.pablo.springCRUD1.Entity.Car;

import java.util.List;

/**
 * Created by Pablo on 05.11.2016.
 */
public class CostCounter {

    private SizeChecker  sizeChecker;

    public  double getCarCost(Car car){
        return sizeChecker.goToStation(car).washingPrize();
    }

    public double getFullCost(List<Car> carList){

        double cost = 0;
        for (Car car: carList){
             cost += sizeChecker.goToStation(car).washingPrize();
        }
        return cost;
    }
}
