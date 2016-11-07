package com.pablo.springCRUD1.dao;

import com.pablo.springCRUD1.Entity.Client;

import java.util.List;

/**
 * Created by Pablo on 30.07.2016.
 */
public interface ClientDAO {
    void addClient(Client c);
    void updateClient(Client c);
    List<Client> listClient();
    Client getClientById(int id);
    void removeClient(int id);
}
