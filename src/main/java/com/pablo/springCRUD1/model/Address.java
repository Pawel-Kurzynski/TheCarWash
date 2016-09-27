package com.pablo.springCRUD1.model;

import javax.persistence.*;

/**
 * Created by Pablo on 25.08.2016.
 */
@Entity
public class Address {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    private String locality;
    private String zipCode;
    private String street;
    private String streetNumber;

    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "clientId")
    private Client client;

    public Address() {
    }

    public Address(String locality, String zipCode, String street, String streetNumber, Client client) {
        this.locality = locality;
        this.zipCode = zipCode;
        this.street = street;
        this.streetNumber = streetNumber;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", locality='" + locality + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
//                ", client_ID=" + client.getId() +
                '}';
    }
}
