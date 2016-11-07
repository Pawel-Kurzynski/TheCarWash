package com.pablo.springCRUD1.service.washLogic;

/**
 * Created by Pablo on 05.11.2016.
 */
public class Station2 extends WashingStation {

    @Override
    public String name() {
        return "Station 2";
    }

    public Station2(boolean waxing) {
        super(waxing);
    }

    @Override
    public double washingPrize() {
        return 20 + super.waxingPrize();
    }

    @Override
    public double washingTime() {
        return 12.0;
    }

    @Override
    public boolean checkComplete() {
        return false;
    }
}
