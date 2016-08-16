package com.pablo.springCRUD1.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Pablo on 30.07.2016.
 */
public class Client {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;


    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Address")
    private String addres;
}
