package com.pablo.springCRUD1.service;

import com.pablo.springCRUD1.dao.EmployeeDAO;
import com.pablo.springCRUD1.dao.EmployeeDAOImpl;
import com.pablo.springCRUD1.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pablo on 03.08.2016.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeDAO employeeDAO;

    public void setEmployeeDAO(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }

    @Override
    @Transactional
    public void addEmployee(Employee e) {
        this.employeeDAO.addEmployee(e);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee e) {
        this.employeeDAO.updateEmployee(e);
    }

    @Override
    @Transactional
    public List<Employee> listEmployee() {
        return this.employeeDAO.listEmployee();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return this.employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public List<Employee> getEmployeeByName(String name) {
        return this.employeeDAO.getEmployeeByName(name);
    }

    @Override
    @Transactional
    public void removeEmployee(int id) {
        this.employeeDAO.removeEmployee(id);
    }
}
