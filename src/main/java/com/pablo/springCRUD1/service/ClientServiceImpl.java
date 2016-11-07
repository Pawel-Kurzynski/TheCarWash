package com.pablo.springCRUD1.service;

import com.pablo.springCRUD1.dao.ClientDAO;
import com.pablo.springCRUD1.Entity.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Pablo on 17.08.2016.
 */
@Service
public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO;

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    @Transactional
    public void addClient(Client c) {
        this.clientDAO.addClient(c);
    }

    @Override
    @Transactional
    public void updateClient(Client c) {
        this.clientDAO.updateClient(c);
    }

    @Override
    @Transactional
    public List<Client> listClient() {
        return this.clientDAO.listClient();
    }

    @Override
    @Transactional
    public Client getClientById(int id) {
        return this.clientDAO.getClientById(id);
    }

    @Override
    @Transactional
    public void removeClient(int id) {
        this.clientDAO.removeClient(id);
    }
}
