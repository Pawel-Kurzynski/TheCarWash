package com.pablo.springCRUD1.dao;

import com.pablo.springCRUD1.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by Pablo on 30.07.2016.
 */
@Qualifier(value = "employeeDAO")
public interface EmployeeDAO {
    void addEmployee(Employee p);
    void updateEmployee(Employee p);
    List<Employee> listEmployee();
    Employee getEmployeeById(int id);
    void removeEmployee(int id);
}
