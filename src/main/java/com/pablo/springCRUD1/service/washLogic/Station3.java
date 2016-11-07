package com.pablo.springCRUD1.service.washLogic;

/**
 * Created by Pablo on 05.11.2016.
 */
public class Station3 extends WashingStation {

    @Override
    public String name() {
        return "Station 3";
    }

    public Station3(boolean waxing) {
        super(waxing);
    }

    @Override
    public double washingPrize() {
        return 23 + super.waxingPrize();
    }

    @Override
    public double washingTime() {
        return 15.0;
    }

    @Override
    public boolean checkComplete() {
        return false;
    }
}
