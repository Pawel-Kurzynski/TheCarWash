package com.pablo.springCRUD1.dao;

import com.pablo.springCRUD1.model.Client;

import java.util.List;

/**
 * Created by Pablo on 30.07.2016.
 */
public interface ClientDAO {
    void addClient(Client c);
    void updateEmployee(Client c);
    List<Client> listClient();
    Client getClinetById(int id);
    void removeClinet(int id);
}
