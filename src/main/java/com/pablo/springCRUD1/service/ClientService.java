package com.pablo.springCRUD1.service;

import com.pablo.springCRUD1.model.Client;

import java.util.List;

/**
 * Created by Pablo on 17.08.2016.
 */
public interface ClientService {
    void addClient(Client c);
    void updateClient(Client c);
    List<Client> listClient();
    Client getClientById(int id);
    void removeClient(int id);
}
