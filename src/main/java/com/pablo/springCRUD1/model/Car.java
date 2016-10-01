package com.pablo.springCRUD1.model;


import com.sun.istack.NotNull;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;

/**
 * Created by Pablo on 30.07.2016.
 */
@Entity
public class Car {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "clientID")
    private Client client;


    @Column
    private String model;

    @Column
    private double width;

    @Column
    private double high;

    @Column
    private boolean waxing = false;

    @Column
    @NotNull
    private String plateNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public boolean isWaxing() {
        return waxing;
    }

    public void setWaxing(boolean waxing) {
        this.waxing = waxing;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
//                ", client=" + client +
                ", model='" + model + '\'' +
                ", width=" + width +
                ", high=" + high +
                ", waxing=" + waxing +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
