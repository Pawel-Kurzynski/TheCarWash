package com.pablo.springCRUD1.model;

import javax.persistence.*;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 *
 */

@Entity
@Table(name = "Employees")
public class Employee {
    @Column(name="Name")
    private String name;

    @Id
    @Column(name="Employee ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int employeeID;

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setName(String name) {
        this.name = name;
    }
}
