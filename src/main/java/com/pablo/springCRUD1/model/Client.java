package com.pablo.springCRUD1.model;

import javax.persistence.*;

/**
 * Created by Pablo on 30.07.2016.
 */
public class Client {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;


    @Column(name = "First Name", nullable = false)
    private String firstName;

    @Column(name = "Last Name", nullable = false)
    private String lastName;

    @Column(name = "Address")
    private Address address;

    @Column(name = "Car")
    @OneToMany
    private Car car;

    public long getId() {
        return id;
    }

}
