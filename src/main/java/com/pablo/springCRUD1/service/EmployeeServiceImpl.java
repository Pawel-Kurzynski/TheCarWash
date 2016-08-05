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
//@Qualifier(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService{



    public EmployeeServiceImpl() {
    }

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
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
    public void removeEmployee(int id) {
        this.employeeDAO.removeEmployee(id);
    }

    public void setEmployeeDAO(EmployeeDAOImpl employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


}
