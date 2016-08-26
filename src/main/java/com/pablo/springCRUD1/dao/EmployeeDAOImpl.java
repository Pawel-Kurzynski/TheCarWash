package com.pablo.springCRUD1.dao;

import com.pablo.springCRUD1.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pablo on 03.08.2016.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addEmployee(Employee e) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(e);
        logger.info("Employee saved successfully, Employee details: " + e);
    }

    @Override
    public void updateEmployee(Employee e) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(e);
        logger.info("Employee updated successfully, Employee details: " + e);
    }

    @SuppressWarnings("uncheked")
    @Override
    public List<Employee> listEmployee() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();
        for (Employee e: employeeList){
            logger.info("Employees List::" + e);
        }
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee e = (Employee) session.load(Employee.class, new Integer(id));
        logger.info("Employee loaded successfully, Employee details: " + e);
        return e;
    }

    @Override
    public void removeEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee e = (Employee) session.load(Employee.class, new Integer(id));
        if(e != null){
            session.delete(e);
        }
        logger.info("Employee delete successfully, Employee details: " + e);
    }

    @SuppressWarnings("uncheked")
    @Override
    public List<Employee> getEmployeeByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("FROM Employee WHERE Employee.name='?'").setParameter(0, name).list();
        for (Employee e: employeeList){
            logger.info("Employees List::" + e);
        }
        return employeeList;
    }
}
