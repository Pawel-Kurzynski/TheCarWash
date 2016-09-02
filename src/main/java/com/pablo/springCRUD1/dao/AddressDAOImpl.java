package com.pablo.springCRUD1.dao;

import com.pablo.springCRUD1.model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Pablo on 30.08.2016.
 */
public class AddressDAOImpl implements AddressDAO {

    private static final Logger logger = LoggerFactory.getLogger(AddressDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAddress(Address a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(a);
        logger.info("Address saved successfully, Address details: " + a);
    }

    @Override
    public void updateCar(Address a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(a);
        logger.info("Address updated successfully, Address details: " + a);
    }

    @Override
    public List<Address> listAddress() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Address> addressesList = session.createQuery("from Address").list();
        for (Address a: addressesList){
            logger.info("Address List:: " + a);
        }
        return addressesList;
    }

    @Override
    public Address getAddressById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Address a = (Address) session.load(Address.class, new Integer(id));
        logger.info("Address loaded successfully, Address details: " + a);
        return a;
    }

    @Override
    public void removeAddress(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Address a = (Address) session.load(Address.class, new Integer(id));
        if(a!= null){
            session.delete(a);
        }
        logger.info("Address removed successfully, Address details: " + a);
    }
}
