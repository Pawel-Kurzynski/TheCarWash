package com.pablo.springCRUD1.service.washLogic;


/**
 * Created by Pablo on 05.11.2016.
 */
public class Station1 extends WashingStation {

    @Override
    public String name() {
        return "Station 1";
    }

    public Station1(boolean waxing) {
        super(waxing);
    }

    @Override
    public double washingPrize() {

        return 15 + super.waxingPrize();
    }

    @Override
    public double washingTime() {
        return 10.0;
    }

    @Override
    public boolean checkComplete() {
        return false;
    }
}
