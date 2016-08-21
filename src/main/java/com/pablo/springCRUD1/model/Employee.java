package com.pablo.springCRUD1.model;

import javax.persistence.*;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 */

@Entity
@Table(name = "Employee")
public class Employee {
    @Column(name = "name",nullable = false)
    private String name;

    @Id
    @Column(name = "id", length = 30)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length =20)
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
