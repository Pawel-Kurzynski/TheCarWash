package com.pablo.springCRUD1.service.washLogic;

import com.pablo.springCRUD1.Entity.Car;

/**
 * Created by Pablo on 05.11.2016.
 */
public class SizeCheckerImpl implements SizeChecker {

    @Override
    public WashingStation goToStation(Car car) {

        double width = car.getWidth();
        double height = car.getHeight();
        boolean waxing = car.isWaxing();


        if(width<1.5 && height <1.5){
            return new Station1(waxing);
        }else if (width<1.7 && height <1.7){
            return new Station2(waxing);
        }else if(width<2 && height <2){
            return new Station3(waxing);
        }else if(width<2.5 && height <2.3){
            return new Station4(waxing);
        }else {
            return null;
        }
    }

}
