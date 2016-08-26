package com.pablo.springCRUD1.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Pablo on 25.08.2016.
 */
public class Address {

    @Id
    @GeneratedValue
    private long id;

    private String locality;
    private String zipCode;
    private String street;
    private String streetNumber;

    public long getId() {
        return id;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
