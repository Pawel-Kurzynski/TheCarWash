package com.pablo.springCRUD1.dao;

import com.pablo.springCRUD1.model.Address;
import com.pablo.springCRUD1.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Pablo on 03.08.2016.
 */
public class ClientDAOImpl implements ClientDAO{

    private static final Logger logger = LoggerFactory.getLogger(ClientDAOImpl.class);
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addClient(Client c) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        Address address = new Address(null, null, null, null, c);
        session.persist(address);
        c.setAddress(address);
        logger.info("Client saved successfully, Client details: " + c);
    }

    @Override
    public void updateClient(Client c) {
        Session session = this.sessionFactory.getCurrentSession();

        session.update(c);
        logger.info("Client updated successfully, Client details: " + c);
    }

    @SuppressWarnings("uncheked")
    @Override
    public List<Client> listClient() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Client> clientList = session.createQuery("from Client").list();
        for (Client c: clientList){
            logger.info("Client List:: " + c);
        }
        return clientList;
    }

    @Override
    public Client getClientById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Client c = (Client) session.load(Client.class, new Integer(id));
        logger.info("Client loaded successfully, Client details: " + c);
        return c;
    }

    @Override
    public void removeClient(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Client c = (Client) session.load(Client.class, new Integer(id));
        if (c != null){
            session.delete(c);
        }
        logger.info("Client deleted successfully, Client details: " + c);
    }
}
