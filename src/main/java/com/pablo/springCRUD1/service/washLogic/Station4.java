package com.pablo.springCRUD1.service.washLogic;

/**
 * Created by Pablo on 05.11.2016.
 */
public class Station4 extends WashingStation {

    @Override
    public String name() {
        return "Station 4";
    }

    public Station4(boolean waxing) {
        super(waxing);
    }

    @Override
    public double washingPrize() {
        return 25 + super.waxingPrize();
    }

    @Override
    public double washingTime() {
        return 17.0;
    }

    @Override
    public boolean checkComplete() {
        return false;
    }
}
