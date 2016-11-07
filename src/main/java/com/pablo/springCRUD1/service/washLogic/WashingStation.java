package com.pablo.springCRUD1.service.washLogic;

/**
 * Created by Pablo on 05.11.2016.
 */
public abstract class WashingStation implements Washing{

    private boolean waxing;

    public abstract String name();

    public WashingStation() {
    }

    public WashingStation(boolean waxing) {
        this.waxing = waxing;
    }


    double waxingPrize(){
        if (waxing){
            return 20.0;
        }
        else return 0.0;
    }
}
