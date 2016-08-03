package service;

import com.pablo.springCRUD1.model.Employee;

import java.util.List;

/**
 * Created by Pablo on 03.08.2016.
 */
public interface EmployeeService {
    void addEmployee(Employee e);
    void updateEmployee(Employee e);
    List<Employee> listEmployee();
    Employee getEmployeeById(int id);
    void removeEmployee(int id);
}

