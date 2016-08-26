package com.pablo.springCRUD1.dao;

import com.pablo.springCRUD1.model.Employee;

import java.util.List;

/**
 * Created by Pablo on 30.07.2016.
 */
public interface EmployeeDAO {
    void addEmployee(Employee p);
    void updateEmployee(Employee p);
    List<Employee> listEmployee();
    Employee getEmployeeById(int id);
    List<Employee> getEmployeeByName(String name);
    void removeEmployee(int id);
}
