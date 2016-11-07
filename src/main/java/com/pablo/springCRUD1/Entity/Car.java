package com.pablo.springCRUD1.Entity;


import com.sun.istack.NotNull;
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
    private double height;

    @Column
    private boolean waxing = false;

    @Column
    @NotNull
    private String plateNumber;

    public Car() {
    }


    public Car(Client client) {
        this.client = client;
    }

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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
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
                ", height=" + height +
                ", waxing=" + waxing +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
